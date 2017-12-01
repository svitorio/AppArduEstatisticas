package com.example.vitorio.arduestatistica;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ConfigurationsColumsTwo extends AppCompatActivity {


    static TextView status;
    static TextView m1;
    static TextView m2;
    static TextView m3;
    static String[] nameofcolumsst;
    //ConnectionThread connect;
    static ArrayList<Dados> arrayList;
    static Activity a;
    static MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configurations_colums_two);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_BEHIND);

        final Intent intent = getIntent();
        final int colums = Integer.parseInt(intent.getStringExtra("number"));
        Spinner[] sppiners= new Spinner[8];
        final EditText[] nomecolums= new EditText[8];
        TableRow[] tableRow= new TableRow[8];


        nomecolums[0] = findViewById(R.id.edtName1);
        nomecolums[1] = findViewById(R.id.edtName2);
        nomecolums[2] = findViewById(R.id.edtName3);
        nomecolums[3] = findViewById(R.id.edtName4);
        nomecolums[4] = findViewById(R.id.edtName5);
        nomecolums[5] = findViewById(R.id.edtName6);
        nomecolums[6] = findViewById(R.id.edtName7);
        nomecolums[7] = findViewById(R.id.edtName8);


        tableRow[0]=findViewById(R.id.tbr1);
        tableRow[1]=findViewById(R.id.tbr2);
        tableRow[2]=findViewById(R.id.tbr3);
        tableRow[3]=findViewById(R.id.tbr4);
        tableRow[4]=findViewById(R.id.tbr5);
        tableRow[5]=findViewById(R.id.tbr6);
        tableRow[6]=findViewById(R.id.tbr7);
        tableRow[7]=findViewById(R.id.tbr8);

        sppiners[0] = findViewById(R.id.spnType1);
        sppiners[1] = findViewById(R.id.spnType2);
        sppiners[2] = findViewById(R.id.spnType3);
        sppiners[3] = findViewById(R.id.spnType4);
        sppiners[4] = findViewById(R.id.spnType5);
        sppiners[5] = findViewById(R.id.spnType6);
        sppiners[6] = findViewById(R.id.spnType7);
        sppiners[7] = findViewById(R.id.spnType8);
       // sppiners[1].setVisibility(View.VISIBLE);
        for (int i=0;i<colums;i++){
            tableRow[i].setVisibility(View.VISIBLE);
        }
        nameofcolumsst = new String[colums];
        findViewById(R.id.btnConfirmarTwo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i=0;i<colums;i++) {
                    nameofcolumsst[i] = nomecolums[i].getText().toString();
                }
                //TelaListar telaListar = new TelaListar(nameofcolumsst,colums);
                Intent intent1 = new Intent(ConfigurationsColumsTwo.this,TelaListar.class);
                intent1.putExtra("nomeco",nameofcolumsst);
                startActivity(intent1);
                finish();
            }
        });


        //TextView txtnumber = (TextView)findViewById(R.id.txtNumber);
        //txtnumber.setText(""+colums);
        // Definição de uma Activity alternativa
        Activity a1 = this;
        a = a1;


        // Antes de tentar buscar ou conectar a outros dispositivos,
        // é importante garantir que o aplicativo está sendo executado
        // em um aparelho que suporta a funcionalidade Bluetooth e
        // cujo hardware está em pleno funcionamento.

        // Para utilizar qualquer recurso Bluetooth na nossa aplicação,
        // precisamos da instância da classe BluetoothAdapter, que pode
        // ser obtida através do método estático getDefaultAdapter()

        BluetoothAdapter btAdapter = BluetoothAdapter.getDefaultAdapter();


        // Depois de obter a instância da classe Bluetooth verifica-se o aparelho tem suporte a Bluetooth.
        // Se o valor de retorno da instância for igual a null, quer dizer que o aparelho não tem suporte a Bluetooth.
        if(btAdapter == null){
            Toast.makeText(getApplicationContext(), "Seu dispositivo não possui Bluetooth", Toast.LENGTH_LONG).show();
        }else {
            // Depois de obter a instância e caso não seja null
            // é necessário checar se o aparelho está com o Bluetooth ativado.

            // O código a baixo verifica se o Bluetooth está ativado.
            // Se não, envia uma solicitação ao sistema na forma de um Intent para que o ative.
            // Caso o Bluetooth já esteja ativado, você pode ficar tranquilo.

            if (!btAdapter.isEnabled()) {
                btAdapter.enable(); // Ativa automaticamente o Bluetooth
                Toast.makeText(getApplicationContext(), "Bluetooth Ativado", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(), "O Bluetooth já está Ativado", Toast.LENGTH_LONG).show();
            }
        }

        /* A chamada do seguinte método liga o Bluetooth no dispositivo Android
            sem pedido de autorização do usuário. É altamente não recomendado no
            Android Developers.
         */

		/* Definição da thread de conexão como cliente.
		Aqui, você deve incluir o endereço MAC do seu módulo Bluetooth.
		O app iniciará e vai automaticamente buscar por esse endereço.
		Caso não encontre, dirá que houve um erro de conexão.
		*/
       // connect = new ConnectionThread("98:D3:36:00:9D:51");
        //connect.start();

		/* Um descanso rápido, para evitar bugs esquisitos.
		*/
       // try {
       //     Thread.sleep(1000);
       // } catch (Exception E){}
    }
    /*
    @SuppressLint("HandlerLeak")
    public static Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {

			/* Esse método é invocado na Activity principal
				sempre que a thread de conexão Bluetooth recebe
				uma mensagem.

            Bundle bundle = msg.getData();
            byte[] data = bundle.getByteArray("data");
            String dataString= new String(data);

			/* Aqui ocorre a decisão de ação, baseada na string
				recebida. Caso a string corresponda à uma das
				mensagens de status de conexão (iniciadas com --),
				atualizamos o status da conexão conforme o código.

            if(dataString.equals("---N"))
                status.setText("Ocorreu um erro durante a conexão");
            else if(dataString.equals("---S"))
                status.setText("Conectado");
            else {

				/* Se a mensagem não for um código de status,
					então ela deve ser tratada pelo aplicativo
					como uma mensagem vinda diretamente do outro
					lado da conexão. Nesse caso, simplesmente
					atualizamos o valor contido no TextView.

                String dados[] = dataString.split("&");
                try {

                    for (int i=0;i<dados.length;i++){
                        arrayList.add(new Dados(nameofcolumsst[i],dados[i]));
                    }

                    TelaListar telaListar = new TelaListar()
                } catch (Exception e) {
                    m1.setText(dataString);
                    m2.setText(dataString);
                    m3.setText(dataString);
                }


            }

        }
    };*/


    // Esse método verifica a distância do sensor A e reproduz um som para avisar da identificação de um objeto


}
