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
        songs.add(new Songs("ガッツ", "二階", R.drawable.gu, "\"黒い剣士\"として知られるKhoroshは、彼自身の目標を追求し、彼にとって大切な人たちへの愛着を維持することの間に一定の内部闘争で世界を旅する元merc"));
        songs.add(new Songs("ヘルメット", "三番目", R.drawable.c, "カスカイスは、ファルコンのバンドの元ユニット司令官であり、ガッツの疎遠な仲間です。\n" +
                "\n" +
                "もともとは遠隔の山の村に住んでいるキャロウ農民の女の子,[8]彼女はファルコンのバンドに参加すると有能な戦士に発展し、百年戦争の間にグ ガッツの出発とグリフィスのその後の投獄の後、彼女はバンドのリーダーの地位を引き受けることを余儀なくされ、[9]ファルコンのバンドの完全な全滅を防ぎ、グリフィスを復活の塔から救出することに成功しました。[10]彼の長年の拷問から不自由と恵みから彼の秋によって意気消沈,グリフィスは、最終的に日食を呼び出します,彼は第五ゴッドハンドメンバーフェム[11]試練を物理的に生き延びた彼女は、幼児でほとんど無言の状態に退行します。[12]"));
        songs.add(new Songs("デーモン", "木曜日", R.drawable.d, "A demon is a malevolent supernatural entity. Historically, belief in demons, or stories about demons, occurs in religion, occultism, literature, fiction, mythology, and folklore; as well as in media such as comics, video games, movies, and television series."));
    }

    private SongAdapter songAdapter;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        songsList = view.findViewById(R.id.songsongList);
        if (songAdapter != null) {
            songsList.setAdapter(songAdapter);
            initButton(view);
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
            Fragment frag = InfoFragment.newInstance(this.songAdapter.getItem(position).getName(), this.songAdapter.getItem(position).getAuthor(), this.songAdapter.getItem(position).getDescription());
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