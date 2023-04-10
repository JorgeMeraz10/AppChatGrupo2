package com.example.appchatgrupo2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.widget.PopupMenu;
import androidx.fragment.app.Fragment;

public class ChatsFragment extends Fragment {
    private String groupName;
    private int participants;

    private static final int REQUEST_SELECT_IMAGE = 1;
    private static final int REQUEST_RECORD_AUDIO = 2;
    private static final int REQUEST_RECORD_VIDEO = 3;

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
        TextView textViewGroupName = view.findViewById(R.id.chat_group_name_textview);
        textViewGroupName.setText(groupName);

        // Configurar el botón enviar
        ImageView buttonSend = view.findViewById(R.id.send_button);
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implementar el envío del mensaje
            }
        });

        // Configurar el botón adjuntar
        ImageView buttonAttach = view.findViewById(R.id.Button_Attach);
        buttonAttach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implementar la selección de archivo para adjuntar
                showAttachmentOptions(v);
            }
        });

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_SELECT_IMAGE && resultCode == getActivity().RESULT_OK && data != null) {
            Uri selectedImageUri = data.getData();
            // Usa la imagen seleccionada aquí
        }

        if (requestCode == REQUEST_RECORD_AUDIO && resultCode == getActivity().RESULT_OK && data != null) {
            // Usa el audio grabado aquí
        }

        if (requestCode == REQUEST_RECORD_VIDEO && resultCode == getActivity().RESULT_OK && data != null) {
            // Usa el video grabado aquí
        }

        if (requestCode == REQUEST_SELECT_IMAGE && resultCode == getActivity().RESULT_OK) {
            // Obtiene el archivo URI y el PATH
            Uri uri = data.getData();
            String path = uri.getPath();

            // Usar el archivo PATH como se necesite
            // ...
        }

    }




    private void selectImageFromGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, REQUEST_SELECT_IMAGE);
    }

    private void recordAudio() {
        Intent intent = new Intent(MediaStore.Audio.Media.RECORD_SOUND_ACTION);
        startActivityForResult(intent, REQUEST_RECORD_AUDIO);
    }

    private void recordVideo() {
        Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        startActivityForResult(intent, REQUEST_RECORD_VIDEO);
    }


    //Metodo para mostrar las opciones y llamar sus metodos funcionales
    public void showAttachmentOptions(View view) {
        PopupMenu popup = new PopupMenu(getContext(), view);
        popup.getMenuInflater().inflate(R.menu.attachment_menu, popup.getMenu());
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_image:
                        // llamar Elemento de Imagen
                        selectImageFromGallery();
                        return true;
                    case R.id.menu_document:
                        //Abrir Archivos
                        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                        intent.setType("*/*"); // Permitir seleccionar cualquier tipo de archivo
                        startActivityForResult(intent, 1);
                        return true;
                    case R.id.menu_audio:
                        // llamar Elemento de Audio
                        recordAudio();
                        return true;
                    case R.id.menu_video:
                        // llamar Elemento de Video
                        recordVideo();
                        return true;
                    default:
                        return false;
                }
            }
        });
        popup.show(); // muestra el menú emergente
    }

}
