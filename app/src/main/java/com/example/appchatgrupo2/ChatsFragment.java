package com.example.appchatgrupo2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class ChatsFragment extends Fragment {
    private String groupName;
    private int participants;

    public ChatsFragment(String name, int participants) {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chats, container, false);

        // Obtener los datos del grupo
        Bundle bundle = getArguments();
        if (bundle != null) {
            groupName = bundle.getString("group_name");
            participants = bundle.getInt("participants");
        }

        // Mostrar los datos del grupo en la pantalla
        TextView textViewGroupName = view.findViewById(R.id.text_view_group_name);
        textViewGroupName.setText(groupName);
        TextView textViewParticipants = view.findViewById(R.id.text_view_participants);
        textViewParticipants.setText(participants + " participantes");

        // Configurar el botón enviar
        Button buttonSend = view.findViewById(R.id.button_send);
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implementar el envío del mensaje
            }
        });

        // Configurar el botón adjuntar
        Button buttonAttach = view.findViewById(R.id.button_attach);
        buttonAttach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implementar la selección de archivo para adjuntar
            }
        });

        return view;
    }
}
