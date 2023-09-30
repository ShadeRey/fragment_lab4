package com.example.lab4;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;


public class BlankFragment extends Fragment {

    public static BlankFragment newInstance() {
        BlankFragment blankFragment = new BlankFragment();
        return blankFragment;
    }

    ListView songsList;


    static ArrayList<Songs> songs = new ArrayList<Songs>();

    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

    private void setInitialData() {
        songs.add(new Songs("グリフィス", "初め", R.drawable.g, "グリフィスは、新生ファルコン団の現在のリーダーであり、ミッドランド正規軍の最高司令官です。数々の戦いの先頭に立ち、大陸全土で救世主としての名声を高め、「光の鷹」と崇められている。\n" +
                "\n" +
                "オリジナルの鷹の団のリーダーとして、彼とその傭兵たちは百年戦争を終わらせ、戦争で荒廃したミッドランド王国に平和をもたらすことができます。最も信頼していた腹心のガッツが見捨てられた後、グリフィスは衝動的にシャーロット王女をベッドに寝かせ、投獄され、1年に渡るひどい拷問を受け、夢は消滅したかに見えた。彼は最終的にバンドによって救出されるが、彼の極度の無力状態と自分の王国を手に入れたいという終わりのない願望により、彼は5番目のメンバーとしてのゴッド・ハンドとの親族関係のために、5回目の日食の間に仲間たちを犠牲にせざるを得なかった - 悪魔の理想化されたバージョン人間としての抑制を取り除いた自分自身。やがて、彼は物理世界に転生し、自分の夢の実現だけを考えます。それは、クシャンのミッドランド侵略の阻止、彼が促すアストラル界の大咆哮、そして彼のユートピアの台頭によって実現します。首都ファルコニア。"));
        songs.add(new Songs("ガッツ", "二階", R.drawable.gu));
        songs.add(new Songs("ヘルメット", "三番目", R.drawable.c));
        songs.add(new Songs("デーモン", "木曜日", R.drawable.d));
    }

    private SongAdapter songAdapter;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        songsList = view.findViewById(R.id.songsongList);
        if (songAdapter != null) {
            songsList.setAdapter(songAdapter);
            return;
        }
        setInitialData();
        songAdapter = new SongAdapter(getContext(), R.layout.list_item, songs);
        songAdapter.setOnLongItemClickListener((view1, item, position) -> {
            deleteDialog(position);

            //songs.remove(position);
            //songAdapter.notifyDataSetChanged();
            return true;
        });
        songAdapter.setOnItemClickListener((parent, view1, position) -> {
            Fragment frag = InfoFragment.newInstance(this.songAdapter.getItem(position).getName(), this.songAdapter.getItem(position).getAuthor());
            requireActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_fragment, frag)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    .addToBackStack(null)
                    .commit();
        });
        songsList.setAdapter(songAdapter);
        //songsList.setOnItemLongClickListener();
        initButton(view);
    }

    private void initButton(View view) {
        Button btn = view.findViewById(R.id.btn_add);
        btn.setOnClickListener(this::showDialog);
    }

    public void showDialog(View v) {
        if (songAdapter == null) return;
        CustomDialogFragment dialog = new CustomDialogFragment(songAdapter);
        dialog.show(requireActivity().getSupportFragmentManager(), "custom");
    }

    public void deleteDialog(int position) {
        DeleteDialogFragment deleteDialogg = new DeleteDialogFragment(songAdapter, position);
        deleteDialogg.show(requireActivity().getSupportFragmentManager(), "delete");
    }
}