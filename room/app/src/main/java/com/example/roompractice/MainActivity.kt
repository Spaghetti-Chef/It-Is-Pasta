package com.example.roompractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.roompractice.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var db: UserDatabase
    private lateinit var userListAdapter: UserListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        userListAdapter = UserListAdapter()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = UserDatabase.getInstance(applicationContext)!!
        refreshUserList()

        // 저장 버튼 누르면
        binding.btnSave.setOnClickListener {
            addUser()
            refreshUserList()
        }

        binding.btnDeleteAll.setOnClickListener {
            deleteAllUser()
            refreshUserList()
        }
    }

    private fun addUser(){
        val name = binding.etName.text.toString()
        val email = binding.etAge.text.toString()

        CoroutineScope(Dispatchers.IO).launch {
            db.userDao().insertUser(User(name, email))
        }
    }

    private fun refreshUserList(){
        var userList = "유저 리스트\n"

        CoroutineScope(Dispatchers.Main).launch {
            val users = CoroutineScope(Dispatchers.IO).async {
                db.userDao().getAllUser()
            }.await()

            for(user in users){
                userList += "이름: ${user.name}, 이메일: ${user.email}\n"
            }
            binding.tvPerson.text = userList
        }
    }

    private fun deleteAllUser() {
        CoroutineScope(Dispatchers.IO).launch {
            db.userDao().deleteAll()
        }
    }
}