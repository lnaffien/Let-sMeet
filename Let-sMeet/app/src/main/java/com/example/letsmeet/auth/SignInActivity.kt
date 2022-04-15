package com.example.letsmeet.auth

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.letsmeet.MainActivity
import com.example.letsmeet.PlaceDetailsActivity
import com.example.letsmeet.R
import com.example.letsmeet.placeRecyclerView.PlaceViewHolder
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import java.util.*

import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.ActionCodeSettings
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import java.lang.Exception


class SignInActivity : AppCompatActivity()
{

    val firebase = FirebaseAuth.getInstance()
    val RC_SIGN_IN = 42

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
    }

    /********************************
     *       SIGN IN WITH MAIL      *
     ********************************/

    fun signInMail()
    {
        val showPlaceIntent = Intent(this, MainActivity::class.java)
        //showPlaceIntent.putExtra(PlaceViewHolder.PLACE_KEY, place)
        this.startActivity(showPlaceIntent)
    }

    /********************************
     *      SIGN IN WITH GOOGLE     *
     ********************************/

    fun signInGoogle()
    {
        val googleSignInOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_GAMES_SIGN_IN)
            //.requestIdToken(R.string.)
            .requestEmail()
            .build()
        val googleSignInClient : GoogleSignInClient = GoogleSignIn.getClient(this, googleSignInOptions)

        //val firebase = FirebaseAuth.getInstance()
        checkUser()

        val intent = googleSignInClient.signInIntent

        startActivityForResult(intent, RC_SIGN_IN)
    }

    private fun checkUser() {
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)
    {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == RC_SIGN_IN)
        {
            Log.e("Google Sign In", "intent success")
            val accountTask = GoogleSignIn.getSignedInAccountFromIntent(data)
            try
            {
                val account = accountTask.getResult(ApiException::class.java)
                firebaseGoogle(account)
            } catch (e: Exception)
            {
                Log.e("Google Sign In", "connection failed: ${e.message}")
            }
        }
    }

    private fun firebaseGoogle(account : GoogleSignInAccount)
    {
        Log.e("Google Sign In", "begin firebase connection")
        val credential = GoogleAuthProvider.getCredential(account!!.idToken, null)
        firebase.signInWithCredential(credential)
            .addOnSuccessListener { authResult ->
                Log.e("Google Sign In", "connection succeed")

                val firebaseUser = firebase.currentUser
                val uid = firebaseUser!!.uid
                val email = firebaseUser.email

                if (authResult.additionalUserInfo!!.isNewUser)
                {
                    Log.e("Google Sign In", "New account created")
                    Toast.makeText(this, "New account created", Toast.LENGTH_SHORT).show()
                }
                else
                {
                    Log.e("Google Sign In", "Accessing account info")
                    Toast.makeText(this, "Loading...", Toast.LENGTH_SHORT).show()
                }
                val showPlaceIntent = Intent(this, MainActivity::class.java)
                //showPlaceIntent.putExtra(PlaceViewHolder.PLACE_KEY, place)
                this.startActivity(showPlaceIntent)
            }
            .addOnFailureListener{ e ->
                Log.e("Google Sign In", "Login failed : ${e.message}")
                Toast.makeText(this, "Login failed : ${e.message}", Toast.LENGTH_SHORT).show()


            }
    }

}