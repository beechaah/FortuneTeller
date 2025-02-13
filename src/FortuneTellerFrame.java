import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame
{
    private JTextArea fortuneArea;
    private ArrayList<String> fortunes;
    private int lastFortuneIndex = -1;
    private ImageIcon icon;
    private JPanel mainPnl, titlePnl, fortunePnl, commandPnl;

    public FortuneTellerFrame()
    {
        mainPnl = new JPanel();
        titlePnl = new JPanel();
        fortunePnl = new JPanel();
        commandPnl = new JPanel();

        setTitle("Fortune Teller");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        TitlePanel();
        FortunePanel();
        CommandPanel();

        mainPnl.setLayout(new BorderLayout());
        mainPnl.add(titlePnl, BorderLayout.NORTH);
        mainPnl.add(new JScrollPane(fortuneArea), BorderLayout.CENTER);
        mainPnl.add(commandPnl, BorderLayout.SOUTH);

        add(mainPnl);

        initializeFortunes();

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        setSize(screenSize.width * 3 / 4, screenSize.height * 3 / 4);
        setLocationRelativeTo(null);
    }

    private void TitlePanel()
    {
        JLabel titleLabel = new JLabel("Fortune Teller", JLabel.CENTER);
        icon = new ImageIcon("src/fortuneteller.jpg");
        titleLabel.setIcon(icon);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 32));
        titlePnl.add(titleLabel);
        titleLabel.setHorizontalTextPosition(JLabel.CENTER);
        titleLabel.setVerticalTextPosition(JLabel.BOTTOM);
    }

    private void FortunePanel()
    {
        fortuneArea = new JTextArea(10, 20);
        fortuneArea.setFont(new Font("Serif", Font.PLAIN, 24));
        JScrollPane scrollPane = new JScrollPane(fortuneArea);
        fortunePnl.add(scrollPane);
    }

    private void CommandPanel()
    {
        JButton readFortuneButton = new JButton("Read My Fortune!");
        JButton quitButton = new JButton("Quit");

        readFortuneButton.setFont(new Font("Serif", Font.PLAIN, 24));
        quitButton.setFont(new Font("Serif", Font.PLAIN, 24));

        readFortuneButton.addActionListener(e -> displayRandomFortune());
        quitButton.addActionListener(e -> System.exit(0));

        commandPnl.add(readFortuneButton);
        commandPnl.add(quitButton);
    }

    private void initializeFortunes()
    {
        fortunes = new ArrayList<>();
        fortunes.add("Today is your lucky day!");
        fortunes.add("You will find a fortune in unexpected places.");
        fortunes.add("Happiness is around the corner.");
        fortunes.add("You will conquer your fears.");
        fortunes.add("A pleasant surprise is waiting for you.");
        fortunes.add("Good things are coming your way!");
        fortunes.add("You'll find a new element of the periodic table.");
        fortunes.add("You will be happy today.");
        fortunes.add("You'll get straight A's this semester!");
        fortunes.add("You'll get a new pet!");
        fortunes.add("You'll change lives for the better!");
        fortunes.add("You'll win a lot of money!");
    }

    private void displayRandomFortune()
    {
        Random random = new Random();
        int fortuneIndex;
        do
        {
            fortuneIndex = random.nextInt(fortunes.size());
        } while (fortuneIndex == lastFortuneIndex);
        lastFortuneIndex = fortuneIndex;
        fortuneArea.append(fortunes.get(fortuneIndex) + "\n");
    }
}
