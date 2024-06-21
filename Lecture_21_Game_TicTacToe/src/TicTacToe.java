import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe extends JFrame implements ActionListener {
    public static int BOARD_SIZE = 3;

    public static enum GameStatus{
        Incomplete,Xwins,Zwins,Tie;
    }

    // buttons is an Array of type JButton; to store JButton type button.
    private JButton[][] buttons = new JButton[BOARD_SIZE][BOARD_SIZE];
    boolean crossTurn = true;
    public TicTacToe(){
        super.setTitle("TicTacToe");
        super.setSize(800,800);
        GridLayout grid = new GridLayout(BOARD_SIZE,BOARD_SIZE);
        super.setLayout(grid);
        Font font = new Font("Cpmic Sans", 1, 150);
        for(int row = 0; row< BOARD_SIZE; row++){
            for(int col =0; col<BOARD_SIZE; col++){
                JButton button = new JButton("");
                buttons[row][col] = button;
                button.setFont(font);
                button.addActionListener(this);
                super.add(button);
            }
        }
        super.setResizable(false);
        super.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clicked_Button = (JButton) e.getSource();
        makeMove(clicked_Button);
        GameStatus gs = this.getGameStatus();
        if(gs == GameStatus.Incomplete){
            return;
        }
        declareWinner(gs);

        int choice = JOptionPane.showConfirmDialog(this, "Do You Want To Restart The Game");
        if(choice == JOptionPane.YES_OPTION){
            for(int row = 0; row< BOARD_SIZE; row++){
                for(int col =0; col<BOARD_SIZE; col++){
                    buttons[row][col].setText("");
                }
            }
            crossTurn =true;
        }else{
            super.dispose();
        }
    }
    private void makeMove(JButton clicked_Button) {
        String btntext = clicked_Button.getText();
        if (!btntext.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Invalid Move");
        } else {
            if (crossTurn) {
                clicked_Button.setText("X");
            } else {
                clicked_Button.setText("0");
            }
            crossTurn = !crossTurn;
        }
    }

    private GameStatus getGameStatus() {
        String text1 = "";
        String text2 = "";
        int row = 0, col = 0;

        // text inside rows
        row = 0;
        while (row < BOARD_SIZE) {
            col = 0;
            while (col < BOARD_SIZE - 1) {
                text1 = buttons[row][col].getText();
                text2 = buttons[row][col + 1].getText();
                if (!text1.equals(text2) || text1.isEmpty()) {
                    break;
                }
                col++;
            }
        }
        if (col == BOARD_SIZE - 1) {
            if (text1.equals("x")) {
                return GameStatus.Xwins;
            } else {
                return GameStatus.Zwins;
            }
        }
        row++;
        // Text Inside Cols
        col = 0;
        while (col < BOARD_SIZE) {
            row = 0;
            while (row < BOARD_SIZE - 1) {
                text1 = buttons[row][col].getText();
                text2 = buttons[row][col + 1].getText();
                if (!text1.equals(text2) || text1.isEmpty()) {
                    break;
                }
                row++;
            }
        }
        if (row == BOARD_SIZE - 1) {
            if (text1.equals("x")) {
                return GameStatus.Xwins;
            } else {
                return GameStatus.Zwins;
            }
        }
        col++;

    // Test Inside Diagonal
        row = 0;
        col =0;
        while(row<BOARD_SIZE-1){
            text1 = buttons[row][col].getText();
            text2 = buttons[row+1][col + 1].getText();
            if (!text1.equals(text2) || text1.isEmpty()) {
                break;
            }
            row++;
            col++;
        }
        if(row == BOARD_SIZE-1){
            if (text1.equals("x")) {
                return GameStatus.Xwins;
            } else {
                return GameStatus.Zwins;
            }
        }


        // Test_2 Diagonal
        row = 0;
        col =BOARD_SIZE-1;
        while(row<BOARD_SIZE-1){
            text1 = buttons[row][col].getText();
            text2 = buttons[row+1][col -1].getText();
            if (!text1.equals(text2) || text1.isEmpty()) {
                break;
            }
            row++;
            col--;
        }
        if(col == 0){
            if (text1.equals("x")) {
                return GameStatus.Xwins;
            } else {
                return GameStatus.Zwins;
            }
        }

        String txt ="";
        for(row=0;row<BOARD_SIZE;row++){
            for(col =0; col<BOARD_SIZE;col++){
                txt = buttons[row][col].getText();
                if(txt.length()==0){
                    return GameStatus.Incomplete;
                }
            }
        }
        return GameStatus.Tie;
    }

    private void declareWinner(GameStatus gs) {
        if(gs == GameStatus.Xwins){
            JOptionPane.showMessageDialog(this, "X Wins");
        } else if (gs == GameStatus.Zwins) {
            JOptionPane.showMessageDialog(this, "O Wins");
        } else{
            JOptionPane.showMessageDialog(this, "It's A Tie");
        }
    }

}
