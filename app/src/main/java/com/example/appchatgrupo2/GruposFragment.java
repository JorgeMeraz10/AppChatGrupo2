package com.example.appchatgrupo2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;

public class GruposFragment extends Fragment {
    private ListView listView;
    private GruposCustomAdapter groupsAdapter;
    private ArrayList<Grupos> groups;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_grupos, container, false);

        // Obtener el ListView
        listView = view.findViewById(R.id.list_view_groups);

        // Inicializar el adaptador de grupos
        groups = new ArrayList<>();
        groups.add(new Grupos("Programacion Movil I",  20));
        groups.add(new Grupos("Redes IV",  10));
        groups.add(new Grupos("Ingles I",  20));
        groups.add(new Grupos("Redes III",  10));
        groups.add(new Grupos("Programacion Avanzada I",  10));
        groups.add(new Grupos("Circuitos Electricos I",  50));
        groups.add(new Grupos("Programacion Movil II",  40));
        groups.add(new Grupos("Analisís y Diseño de Algoritmos",  25));
        groupsAdapter = new GruposCustomAdapter(getContext(), groups);

        // Asignar el adaptador al ListView
        listView.setAdapter(groupsAdapter);

        // Agregar un listener al ListView para abrir la pantalla de chats al hacer clic en un grupo
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Grupos grupoSeleccionado = groups.get(position);
                Fragment fragment = new ChatsFragment(grupoSeleccionado.getName(), grupoSeleccionado.getParticipants());
                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        return view;
    }
}
