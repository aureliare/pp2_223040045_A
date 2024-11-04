package tugas7.Membership.src.view.main;

import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import tugas7.Membership.src.model.*;
import tugas7.Membership.src.view.jenismember.JenisMemberFrame;
import tugas7.Membership.src.view.member.MemberFrame;
import tugas7.Membership.src.dao.*;

public class MainFrame extends JFrame {
    private JenisMemberFrame jenisMemberFrame;
    private MemberFrame memberFrame;
    private JButton buttonJenisMember;
    private JButton buttonMember;
    private JenisMemberDao jenisMemberDao;
    private MemberDao memberDao;

    public MainFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 500);
        // Inisialisasi DAO
        this.jenisMemberDao = new JenisMemberDao();
        this.memberDao = new MemberDao();
        // Inisialisasi frame
        this.jenisMemberFrame = new JenisMemberFrame(jenisMemberDao);
        this.memberFrame = new MemberFrame(memberDao, jenisMemberDao);

        this.setLayout(new FlowLayout());
        MainButtonActionListener actionListener = new MainButtonActionListener(this);

        this.buttonJenisMember = new JButton("Jenis Member");
        this.buttonMember = new JButton("Member");

        this.buttonJenisMember.addActionListener(actionListener);
        this.buttonMember.addActionListener(actionListener);


        this.add(buttonJenisMember);
        this.add(buttonMember);
    }

    public JButton getButtonJenisMember(){
        return buttonJenisMember;
    }

    public JButton getButtonMember(){
        return buttonMember;
    }

    public void showJenisMemberFrame(){
        if(jenisMemberFrame != null){
            jenisMemberFrame = new JenisMemberFrame(jenisMemberDao);
        }

        jenisMemberFrame.setVisible(true);
    }

    public void showMemberFrame(){
        if(memberFrame!= null){
            memberFrame = new MemberFrame(memberDao, jenisMemberDao);
        }
        memberFrame.populateComboJenis();
        memberFrame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MainFrame mainFrame = new MainFrame();
                mainFrame.setVisible(true);
            }
        });   
    }

    public JenisMemberFrame getJenisMemberFrame() {
        return jenisMemberFrame;
    }

    public void setJenisMemberFrame(JenisMemberFrame jenisMemberFrame) {
        this.jenisMemberFrame = jenisMemberFrame;
    }
}