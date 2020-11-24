package ui;

import database.DatabaseConnectionHandler;
import delegates.SearchDelegate;
import model.MovieModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ProjectUI extends JFrame {
    private static final int TEXT_FIELD_WIDTH = 20;

    private SearchDelegate delegate;

    private JTextField typeField;
    private JTextField langField;
    private JTextField formatField;
    private JTextField genreField;


    public ProjectUI() {
        super("Project");
    }

    public void showFrame(SearchDelegate delegate) {
        this.delegate = delegate;

        JLabel movieLabel = new JLabel("Movie Name: ");
        JLabel langLabel = new JLabel("Language: ");
        JLabel genreLabel = new JLabel("Genre: ");
        JLabel formatLabel = new JLabel("Format: ");


        typeField = new JTextField(TEXT_FIELD_WIDTH);
        langField = new JTextField(TEXT_FIELD_WIDTH);
        formatField = new JTextField(TEXT_FIELD_WIDTH);
        genreField = new JTextField(TEXT_FIELD_WIDTH);

        JButton viewButton = new JButton("Project");

        JPanel contentPane = new JPanel();
        this.setContentPane(contentPane);

        // layout components using the GridBag layout manager
        GridBagLayout gb = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();

        contentPane.setLayout(gb);
        contentPane.setBorder(BorderFactory.createEmptyBorder(200, 200, 200, 200));

        String [] a = {"Movie Name","Language","Genre","Format"};                //定义字符串
        JComboBox jcombo = new JComboBox(a);                                                //实例化下拉列表
        JList jlist = new JList(a);                                                            //实例化列表框
        //实例化JScrollPane面板
        JScrollPane jp = new JScrollPane(jlist);
        jp.setPreferredSize(new Dimension(100, 200));
        contentPane.add(jcombo);

        String [] b = {"Movie Name","Language","Genre","Format"};                //定义字符串
        JComboBox jcombo1 = new JComboBox(b);                                                //实例化下拉列表
        JList jlist1 = new JList(b);                                                            //实例化列表框
        //实例化JScrollPane面板
        JScrollPane jp1 = new JScrollPane(jlist1);
        jp1.setPreferredSize(new Dimension(100, 200));
        contentPane.add(jcombo1);

//        String [] a = {"Movie Name","Language","Genre","Format"};                //定义字符串
        JComboBox jcombo2 = new JComboBox(a);                                                //实例化下拉列表
        JList jlist2 = new JList(a);                                                            //实例化列表框
        //实例化JScrollPane面板
        JScrollPane jp2 = new JScrollPane(jlist2);
        jp2.setPreferredSize(new Dimension(100, 200));
        contentPane.add(jcombo2);

//        String [] a = {"Movie Name","Language","Genre","Format"};                //定义字符串
        JComboBox jcombo3 = new JComboBox(a);                                                //实例化下拉列表
        JList jlist3 = new JList(a);                                                            //实例化列表框
        //实例化JScrollPane面板
        JScrollPane jp3 = new JScrollPane(jlist3);
        jp3.setPreferredSize(new Dimension(100, 200));
        contentPane.add(jcombo3);
        // place the type label
//        c.gridwidth = GridBagConstraints.CENTER;
//        c.insets = new Insets(0, 0, 0, 10);
//        gb.setConstraints(movieLabel, c);
//        contentPane.add(movieLabel);
//
//        // place the type field
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(0, 0, 0, 0);
        gb.setConstraints(typeField, c);
        contentPane.add(typeField);
//        jcombo.getActionListeners()
//
//        if (jcombo.getSelectedItem().toString() == "Movie Name") {
//
//
//
//        } else if (jcombo.getSelectedItem().toString() == "Language"){
//
//            String[] langlist = {"English", "French", "Spanish"};
//            JComboBox lanbo = new JComboBox(langlist);                                                //实例化下拉列表
//            JList jlist1 = new JList(langlist);                                                            //实例化列表框
//            //实例化JScrollPane面板
//            JScrollPane jp1 = new JScrollPane(jlist1);
//            jp1.setPreferredSize(new Dimension(100, 200));
//            contentPane.add(lanbo);
//
//
//        }

//
//        // place the location label
//        c.gridwidth = GridBagConstraints.CENTER;
//        c.insets = new Insets(0, 0, 0, 10);
//        gb.setConstraints(langLabel, c);
//        contentPane.add(langLabel);
//
//        // place the location field
//        c.gridwidth = GridBagConstraints.REMAINDER;
//        c.insets = new Insets(0, 0, 0, 0);
//        gb.setConstraints(langField, c);
//        contentPane.add(langField);
//
//        c.gridwidth = GridBagConstraints.CENTER;
//        c.insets = new Insets(0, 0, 0, 10);
//        gb.setConstraints(formatLabel, c);
//        contentPane.add(formatLabel);
//
//        // place the from date field
//        c.gridwidth = GridBagConstraints.REMAINDER;
//        c.insets = new Insets(0, 0, 0, 0);
//        gb.setConstraints(formatField, c);
//        contentPane.add(formatField);
//
//
//        c.gridwidth = GridBagConstraints.CENTER;
//        c.insets = new Insets(0, 0, 0, 10);
//        gb.setConstraints(genreLabel, c);
//        contentPane.add(genreLabel);
//
//        // place the type field
//        c.gridwidth = GridBagConstraints.REMAINDER;
//        c.insets = new Insets(0, 0, 0, 0);
//        gb.setConstraints(genreField, c);
//        contentPane.add(genreField);
//
//        // place the view button
        c.gridwidth = GridBagConstraints.EAST;
        c.insets = new Insets(20, 0, 0, 10);
        gb.setConstraints(viewButton, c);
        contentPane.add(viewButton);

//         register customer button with action event handler
//        viewButton.addActionListener(e -> this.delegate.view(
//                jcombo.getSelectedItem().toString(),
//                typeField.getText()
////                langField.getText()
//        ));

        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(jcombo1.getSelectedItem().toString());
                System.out.println(jcombo2.getSelectedItem().toString());
                System.out.println(jcombo3.getSelectedItem().toString());

                projectResults sui = new projectResults(delegate.project(jcombo.getSelectedItem().toString(), jcombo1.getSelectedItem().toString(),
                        jcombo2.getSelectedItem().toString(),
                        jcombo3.getSelectedItem().toString(),
                        typeField.getText()));
                sui.showFrame();
            }
        });





        // size the window to obtain a best fit for the components
        this.pack();

        // center the frame
        Dimension d = this.getToolkit().getScreenSize();
        Rectangle r = this.getBounds();
        this.setLocation((d.width - r.width) / 2, (d.height - r.height) / 2);

        // make the window visible
        this.setVisible(true);
    }

    public static void main(String[] args) {
        DatabaseConnectionHandler dbHandler = new DatabaseConnectionHandler();
        dbHandler.connectToOracle();
        ProjectUI searchUI = new ProjectUI();
        searchUI.showFrame(new SearchDelegate() {
            @Override
            public ArrayList<MovieModel> view(String selectedItem, String type) {
                return null;
            }

            @Override
            public void show() {

            }

            @Override
            public ArrayList<MovieModel> project(String selectedItem, String c1, String c2, String c3, String type) {
                if (c1 == "Language") {
                    c1 = "language";
                } else if (c1 == "Format") {
                    c1 = "format";
                } else if (c1 == "Genre") {
                    c1 = "movie_genre";
                }

                if (c2 == "Language") {
                    c2 = "language";
                } else if (c2 == "Format") {
                    c2 = "format";
                } else if (c2 == "Genre") {
                    c2 = "movie_genre";
                }

                if (c3 == "Language") {
                    c3 = "language";
                } else if (c3 == "Format") {
                    c3 = "format";
                } else if (c3 == "Genre") {
                    c3 = "movie_genre";
                }
                return dbHandler.project(selectedItem,c1,c2,c3,type);
            }

//            @Override
//            public void view(String selectedItem, String type) {
//
//            }

//            @Override
//            public void view(Object selectedItem, String type) {
//
//            }

//            @Override
//            public void view(String type, String location) {
//
//            }
        });
    }
}
