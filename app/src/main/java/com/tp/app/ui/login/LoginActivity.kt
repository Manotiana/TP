package com.tp.app.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.LayoutInflater
import android.widget.Toast
import com.tp.app.MainActivity

import com.tp.app.data.model.Etudiant
import com.tp.app.databinding.ActivityLoginBinding
import com.tp.app.utils.initial
import com.tp.app.utils.toast

class LoginActivity : AppCompatActivity() {

    //private lateinit var loginViewModel: LoginViewModel
    lateinit var bindings: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindings = ActivityLoginBinding.inflate(LayoutInflater.from(baseContext))
        //setContentView(R.layout.activity_login)
        setContentView(bindings.root)
        //find by id
        //set on click listener
        //create intent
        //start activity
        initViews()
        val test = "Mon test"
        test.toUpperExt()
        val etudiant = Etudiant("RANDRIA","Manotiana")
        etudiant.initial()


        /*val username = findViewById<EditText>(R.id.username)
        val password = findViewById<EditText>(R.id.password)
        val login = findViewById<Button>(R.id.login)
        val loading = findViewById<ProgressBar>(R.id.loading)

        loginViewModel = ViewModelProvider(this, LoginViewModelFactory())
                .get(LoginViewModel::class.java)

        loginViewModel.loginFormState.observe(this@LoginActivity, Observer {
            val loginState = it ?: return@Observer

            // disable login button unless both username / password is valid
            login.isEnabled = loginState.isDataValid

            if (loginState.usernameError != null) {
                username.error = getString(loginState.usernameError)
            }
            if (loginState.passwordError != null) {
                password.error = getString(loginState.passwordError)
            }
        })*/

        /*loginViewModel.loginResult.observe(this@LoginActivity, Observer {
            val loginResult = it ?: return@Observer

            loading.visibility = View.GONE
            if (loginResult.error != null) {
                showLoginFailed(loginResult.error)
            }
            if (loginResult.success != null) {
                updateUiWithUser(loginResult.success)
            }
            setResult(Activity.RESULT_OK)

            //Complete and destroy login activity once successful
            finish()
        })*/

        /*username.afterTextChanged {
            loginViewModel.loginDataChanged(
                    username.text.toString(),
                    password.text.toString()
            )
        }*/

        /*password.apply {
            afterTextChanged {
                loginViewModel.loginDataChanged(
                        username.text.toString(),
                        password.text.toString()
                )
            }

            setOnEditorActionListener { _, actionId, _ ->
                when (actionId) {
                    EditorInfo.IME_ACTION_DONE ->
                        loginViewModel.login(
                                username.text.toString(),
                                password.text.toString()
                        )
                }
                false
            }

            login.setOnClickListener {
                loading.visibility = View.VISIBLE
                loginViewModel.login(username.text.toString(), password.text.toString())
            }
        }*/
    }


    /*private fun updateUiWithUser(model: LoggedInUserView) {
        val welcome = getString(R.string.welcome)
        val displayName = model.displayName
        // TODO : initiate successful logged in experience
        Toast.makeText(
                applicationContext,
                "$welcome $displayName",
                Toast.LENGTH_LONG
        ).show()
    }*/

    /*private fun showLoginFailed(@StringRes errorString: Int) {
        Toast.makeText(applicationContext, errorString, Toast.LENGTH_SHORT).show()
    }*/
    private fun initViews(){
        /*loginButton = findViewById(R.id.login)
        emailInput = findViewById(R.id.username)
        passwordInput = findViewById(R.id.password)
        loginButton.isEnabled = true*/
        bindings.login.setOnClickListener(){
           handleClick()

        }
    }
    fun String.toUpperExt(): String{
        return this.toUpperCase()
    }
    private fun handleClick(){
        if(!bindings.username.text.isNullOrBlank() && !bindings.password.text.isNullOrBlank() ){
            val intent = Intent(baseContext, MainActivity::class.java)
            startActivity(intent)

        }else{
            Toast.makeText(
                baseContext,
                "Please fill all the fields!",
                Toast.LENGTH_LONG
            ).show()
            baseContext.toast("another toast")
        }
    }

}

/**
 * Extension function to simplify setting an afterTextChanged action to EditText components.
 */
/*fun EditText.afterTextChanged(afterTextChanged: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(editable: Editable?) {
            afterTextChanged.invoke(editable.toString())
        }

        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
    })
}*/
