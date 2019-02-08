package softcom.pet_adoption;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import java.util.Calendar;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.widget.RadioButton;


public class MainActivity extends AppCompatActivity {


    Button datePicker,validateButton;

    EditText txtDate,yardResponse,email,fullname, phoneno, refname, fencetype,vetname;



    RadioButton yesbutton, nobutton;


    private int dYear,dMonth,dDay;


    private String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        datePicker = findViewById(R.id.pick_date);

        txtDate = findViewById(R.id.select_date);

        yardResponse = findViewById(R.id.yard_response);


        validateButton = findViewById(R.id.submit_button);

        email = findViewById(R.id.email_text);

        fullname = findViewById(R.id.name_text);

        phoneno = findViewById(R.id.phone_text);

        refname =findViewById(R.id.ref_name);

        fencetype = findViewById(R.id.fencetype_text);

        vetname = findViewById(R.id.vet_name);





        yesbutton = findViewById(R.id.yes_button);

        nobutton = findViewById(R.id.no_button);


        nobutton.setChecked(true);












        datePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Get Current Date
                final Calendar c = Calendar.getInstance();
                dYear = c.get(Calendar.YEAR);
                dMonth = c.get(Calendar.MONTH);
                dDay = c.get(Calendar.DAY_OF_MONTH);



                DatePickerDialog dob = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                        txtDate.setText(dayOfMonth+"-"+(month+1)+"-"+year);
                    }
                },dYear,dMonth,dDay);


                dob.show();










            }
        });






        validateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                validateMethod();

                nonMandatory();
            }
        });

















    }




    public void onRadioButtonClicked(View v){





        //cast the button to boolean.
        boolean  checked = ((RadioButton) v).isChecked();


        // Check which radio button was clicked
        switch(v.getId()) {
            case R.id.yes_button:
                if (checked)
                    // yes
                    yardResponse.setVisibility(View.VISIBLE);


                   yesbutton.getText().toString();





                    break;



            case R.id.no_button:
                if (checked)
                    // no

                    yardResponse.setVisibility(View.GONE);

                    nobutton.getText().toString();


                    break;






        }




    }





    private void validateMethod() {

        Boolean valid = true;

        if(!email.getText().toString().matches(emailPattern)){

            email.setError("Invalid email address");

            return;

        }



        String name = fullname.getText().toString();


        if(TextUtils.isEmpty(name)){

            fullname.setError("Required");
            valid = false;

        }else{

            fullname.setError(null);

        }


        String vemail = email.getText().toString();

        if(TextUtils.isEmpty(vemail)){

            email.setError("Required");
            valid = false;

        }else{

            email.setError(null);

        }


        String dob = txtDate.getText().toString();

        if(TextUtils.isEmpty(dob)){

            txtDate.setError("Required");
            valid = false;

        }else{

            txtDate.setError(null);

        }


        String  phonenum  =  phoneno.getText().toString();

        if(TextUtils.isEmpty(phonenum)){

            phoneno.setError("Required");
            valid = false;

        }else{

            phoneno.setError(null);

        }


        String Rname = refname.getText().toString();

        if(TextUtils.isEmpty(Rname)){


            refname.setError("Required");

            valid = false;

        }else{


            refname.setError(null);



        }












    }


    private void nonMandatory(){


        String fence = fencetype.getText().toString();

        if(TextUtils.isEmpty(fence)){

            fencetype.setText(null);
        }else{


            fencetype.getText();


        }



        String vet =  vetname.getText().toString();

        if (TextUtils.isEmpty(vet)) {

            vetname.setText(null);


        }else{


            vetname.getText();

        }





    }





}
