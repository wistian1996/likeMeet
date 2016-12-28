package br.com.metting.www.likemeet.Activitys;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ToggleButton;

import br.com.metting.www.likemeet.Fragments.CalendarioEventoFragment;
import br.com.metting.www.likemeet.Fragments.AddAmigosEventoFragment;
import br.com.metting.www.likemeet.Fragments.AddLocalEventoFragment;
import br.com.metting.www.likemeet.Fragments.InfoEventoFragment;
import br.com.metting.www.likemeet.R;
import br.com.metting.www.likemeet.Fragments.RelogioEventoFragment;

public class CadastroEventoActivity extends AppCompatActivity {
    ToggleButton toggleButtonCalendario;
    ToggleButton toggleButtonRelogio;
    ToggleButton toggleButtonGrupo;
    ToggleButton toggleButtonMaps;
    ToggleButton toggleButtonInfo;
    Toolbar toolbar;

    // view pager do swep
    private ViewPager mViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_evento);
        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());


        // metodo do swep
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(adapter);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            // define o que fazer ao pasar o dedo trocando de tela
            public void onPageSelected(int position) {
                if (position == 0) {
                    acaoInfo();
                }
                if (position == 1) {
                    acaoCalendario();
                }
                if (position == 2) {
                    acaoRelogio();
                }
                if (position == 3) {
                    acaoLocalizacao();
                }
                if (position == 4) {
                    acaoAmigos();
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        toolbar = (Toolbar) findViewById(R.id.toolbar);

        toolbar.setTitle("Novo evento");
        toolbar.setSubtitle("Adicionar informações");


        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //botoes
        toggleButtonCalendario = (ToggleButton) findViewById(R.id.buttonCalendario);
        toggleButtonRelogio = (ToggleButton) findViewById(R.id.buttonRelogio);
        toggleButtonGrupo = (ToggleButton) findViewById(R.id.ButtonGrupo);
        toggleButtonInfo = (ToggleButton) findViewById(R.id.buttonInfo);
        toggleButtonMaps = (ToggleButton) findViewById(R.id.buttonMaps);

        toggleButtonInfo.setBackgroundResource(R.drawable.info_verde);

        toggleButtonCalendario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //utilizado para trocar de fragmento
                mViewPager.setCurrentItem(1);
            }
        });
        toggleButtonInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewPager.setCurrentItem(0);
            }
        });

        toggleButtonRelogio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewPager.setCurrentItem(2);
            }
        });
        toggleButtonGrupo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewPager.setCurrentItem(4);
            }
        });
        toggleButtonMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewPager.setCurrentItem(3);
            }
        });

    }

    private void acaoInfo() {
        toolbar.setSubtitle("Adicionar informações");

        toggleButtonCalendario.setBackgroundResource(R.drawable.calendario_verde_preto);
        toggleButtonRelogio.setBackgroundResource(R.drawable.relogio_verde_preto);
        toggleButtonGrupo.setBackgroundResource(R.drawable.grupo_preto);
        toggleButtonInfo.setBackgroundResource(R.drawable.info_verde);
        toggleButtonMaps.setBackgroundResource(R.drawable.localizacao_verde_preto);
    }

    private void acaoCalendario() {
        toolbar.setSubtitle("Adicionar data");
        toggleButtonRelogio.setBackgroundResource(R.drawable.relogio_verde_preto);
        toggleButtonGrupo.setBackgroundResource(R.drawable.grupo_preto);
        toggleButtonInfo.setBackgroundResource(R.drawable.infor_verde_preto);
        toggleButtonMaps.setBackgroundResource(R.drawable.localizacao_verde_preto);
        toggleButtonCalendario.setBackgroundResource(R.drawable.calendario_verde);
    }

    private void acaoRelogio() {
        toolbar.setSubtitle("Adicionar horário");
        toggleButtonRelogio.setBackgroundResource(R.drawable.relogio_verde);
        toggleButtonCalendario.setBackgroundResource(R.drawable.calendario_verde_preto);
        toggleButtonGrupo.setBackgroundResource(R.drawable.grupo_preto);
        toggleButtonInfo.setBackgroundResource(R.drawable.infor_verde_preto);
        toggleButtonMaps.setBackgroundResource(R.drawable.localizacao_verde_preto);
    }

    private void acaoAmigos() {
        toolbar.setSubtitle("Adicionar amigos");
        toggleButtonCalendario.setBackgroundResource(R.drawable.calendario_verde_preto);
        toggleButtonRelogio.setBackgroundResource(R.drawable.relogio_verde_preto);
        toggleButtonGrupo.setBackgroundResource(R.drawable.grupo);
        toggleButtonInfo.setBackgroundResource(R.drawable.infor_verde_preto);
        toggleButtonMaps.setBackgroundResource(R.drawable.localizacao_verde_preto);
    }

    private void acaoLocalizacao() {
        toolbar.setSubtitle("Adicionar localização");
        toggleButtonCalendario.setBackgroundResource(R.drawable.calendario_verde_preto);
        toggleButtonRelogio.setBackgroundResource(R.drawable.relogio_verde_preto);
        toggleButtonGrupo.setBackgroundResource(R.drawable.grupo_preto);
        toggleButtonInfo.setBackgroundResource(R.drawable.infor_verde_preto);
        toggleButtonMaps.setBackgroundResource(R.drawable.localizacao_verde);
    }


    // define acao para o botao back do menu toolbar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            default:
                break;
        }
        return true;
    }



    //  a partir daqui sao opçoes do menu swep
    /////////////////////////////////////////
    public class PagerAdapter extends FragmentPagerAdapter {

        public PagerAdapter(FragmentManager fm) {

            super(fm);

        }

        public Fragment getItem(int arg0) {
            switch (arg0) {
                case 0:
                    return new InfoEventoFragment();
                case 1:
                    return new CalendarioEventoFragment();
                case 2:
                    return new RelogioEventoFragment();
                case 3:
                    return new AddLocalEventoFragment();
                case 4:
                    return new AddAmigosEventoFragment();


                default:
                    return null;
            }
        }

        public int getCount() {
            return 5;
        }
    }








}
