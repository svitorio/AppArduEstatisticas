package com.example.vitorio.arduestatistica;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

public class TelaListar extends AppCompatActivity {

    static ListView[] listaDeCadastro;
    ConnectionThread connect;
    static String[] nameofcolumsst;
    int colums;
    static List<Dados> dadossensor = new ArrayList<Dados>();
    static List<Dados> dadossensor1 = new ArrayList<Dados>();
    static List<Dados> dadossensor2 = new ArrayList<Dados>();

    /*public TelaListar(String[] nameofcolum, int colum) {
        this.nameofcolumsst = nameofcolum;
        this.colums = colum;
    }*/
    static Activity a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_listar);
        Intent intent = getIntent();
        listaDeCadastro = new ListView[8];
        nameofcolumsst = getIntent().getStringArrayExtra("nomeco");
        listaDeCadastro[0] = (ListView) findViewById(R.id.list_view);
        listaDeCadastro[1] = (ListView) findViewById(R.id.list_view2);
        listaDeCadastro[2] = (ListView) findViewById(R.id.list_view3);
        System.out.println("Nome Primeira Coluna::"+nameofcolumsst[0]);
        //final ArrayList<Dados> listaDePontosCadastrados;
        Activity a1 = this;
        a = a1;
        //TelaCadastroAdapter adapter = new TelaCadastroAdapter(listaDePontosCadastrados, this);

        //listaDeCadastro.setAdapter(adapter);
        //listaDeCadastro.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        //    @RequiresApi(api = Build.VERSION_CODES.CUPCAKE)
         //   @Override
        //    public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                //irponto(listaDePontosCadastrados.get(position).getLatitude(), listaDePontosCadastrados.get(position).getLongitude(),listaDePontosCadastrados.get(position).getNome());
       //     }

      //  });

        LinearLayout[] linearLayouts = new LinearLayout[8];
        linearLayouts[0] = (LinearLayout)findViewById(R.id.line1);
        linearLayouts[1] = (LinearLayout)findViewById(R.id.line2);
        linearLayouts[2] = (LinearLayout)findViewById(R.id.line3);

        linearLayouts[0].setVisibility(View.VISIBLE);
        linearLayouts[1].setVisibility(View.VISIBLE);
        linearLayouts[2].setVisibility(View.VISIBLE);
        connect = new ConnectionThread("98:D3:36:00:9D:51");
        connect.start();
        try {
            Thread.sleep(1000);
        } catch (Exception E){}
    }

    @SuppressLint("HandlerLeak")
    public static Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {

			/* Esse método é invocado na Activity principal
				sempre que a thread de conexão Bluetooth recebe
				uma mensagem.
			 */
            Bundle bundle = msg.getData();
            byte[] data = bundle.getByteArray("data");
            String dataString= new String(data);
            System.out.println("Mensafem vinda do bluetooth :: "+dataString);
            /* Aqui ocorre a decisão de ação, baseada na string
				recebida. Caso a string corresponda à uma das
				mensagens de status de conexão (iniciadas com --),
				atualizamos o status da conexão conforme o código.
			 */
            if(dataString.equals("---N"))
                System.out.println("Ocorreu um erro durante a conexão");//status.setText("Ocorreu um erro durante a conexão");
            else if(dataString.equals("---S"))
                System.out.println("Conectado");//status.setText("Conectado");
            else {

				/* Se a mensagem não for um código de status,
					então ela deve ser tratada pelo aplicativo
					como uma mensagem vinda diretamente do outro
					lado da conexão. Nesse caso, simplesmente
					atualizamos o valor contido no TextView.
				 */
                String dados[] = dataString.split("&");
                System.out.println("Primerio Sensor :: "+dados[0]);
                //arrayList.add(new Dados(dados[0],dados[0]));
                //List<Dados> cursos = new ArrayList<Dados>(); //= arrayList;
               // cursos.add(new Dados(""+dados[0],""+dados[0]));
                setarValor(dados);

                try {

                   /* for (int i=0;i<dados.length;i++){
                        arrayList.add(new Dados(nameofcolumsst[i],dados[i]));

                    }
                    List<Dados> cursos = arrayList;


                    ArrayAdapter<Dados> adapter = new ArrayAdapter<Dados>(a,
                            android.R.layout.simple_list_item_1, cursos);

                    listaDeCadastro.setAdapter(adapter);
                    for (int i=0;i<dados.length;i++){
                        System.out.println(""+arrayList.get(i).getNameOftable()+"\n"+arrayList.get(i).data);
                    }
                    */

                } catch (Exception e) {
                   // m1.setText(dataString);
                   // m2.setText(dataString);
                   // m3.setText(dataString);
                }


            }

        }
    };

    private static void setarValor(String[] dados) {
        dadossensor.add(new Dados(dados[0],dados[0]));
        ArrayAdapter<Dados> adapter = new ArrayAdapter<Dados>(a,
                android.R.layout.simple_list_item_1, dadossensor);
        dadossensor1.add(new Dados(dados[1],dados[1]));
        ArrayAdapter<Dados> adapter1 = new ArrayAdapter<Dados>(a,
                android.R.layout.simple_list_item_1, dadossensor1);
        dadossensor2.add(new Dados(dados[2],dados[2]));
        ArrayAdapter<Dados> adapter2 = new ArrayAdapter<Dados>(a,
                android.R.layout.simple_list_item_1, dadossensor2);
        listaDeCadastro[0].setAdapter(adapter);
        listaDeCadastro[1].setAdapter(adapter1);
        listaDeCadastro[2].setAdapter(adapter2);
    }

    public static void setaValores(ArrayList<Dados> arrayList) {

    }

   // @RequiresApi(api = Build.VERSION_CODES.CUPCAKE)
    /*private void irponto(final double lat, final double lon, final String nome){

            final Intent intentcad = new Intent(TelaListar.this,Mapa.class);
            intentcad.putExtra("latitude",""+lat);
            intentcad.putExtra("longitude",""+lon);
            intentcad.putExtra("nome", nome);
            intentcad.putExtra("coordenadas","2");
            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("Ponto");
            //alertDialog.setIcon();
            alertDialog.setMessage("Ir para Ponto selecionado?");
            alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Sim",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            startActivity(intentcad);
                            dialog.dismiss();
                            onBackPressed();
                            finish();
                        }
                    });
            alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Não",
                    new DialogInterface.OnClickListener(){
                        public void onClick(DialogInterface dialog, int which){
                            dialog.dismiss();
                            onBackPressed();
                        }
                    });
            alertDialog.show();
    }*/

}
