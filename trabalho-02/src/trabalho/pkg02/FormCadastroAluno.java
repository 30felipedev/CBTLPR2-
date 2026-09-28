package trabalho.pkg02;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.swing.*;

// IFSP CBT ADS 2026 - Linguagem de Programação 2
// Aluno: Felipe Barretto
public class FormCadastroAluno extends JFrame implements ActionListener
{
    private List<Aluno> alunos = new ArrayList<Aluno>();

    private JLabel lblNome = new JLabel("Nome:");
    private JLabel lblIdade = new JLabel("Idade:");
    private JLabel lblEndereco = new JLabel("Endereço:");
    private JTextField txtNome = new JTextField();
    private JTextField txtIdade = new JTextField();
    private JTextField txtEndereco = new JTextField();

    private JButton btnOk = new JButton("Ok");
    private JButton btnLimpar = new JButton("Limpar");
    private JButton btnMostrar = new JButton("Mostrar");
    private JButton btnSair = new JButton("Sair");

    public FormCadastroAluno()
    {
        super("TP02 - LP2I4");
        setSize(400, 180);
        setLocation(50, 50);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel painelSuperior = new JPanel(new GridLayout(3, 2, 10, 10));
        painelSuperior.add(lblNome);
        painelSuperior.add(txtNome);
        painelSuperior.add(lblIdade);
        painelSuperior.add(txtIdade);
        painelSuperior.add(lblEndereco);
        painelSuperior.add(txtEndereco);

        JPanel painelInferior = new JPanel(new GridLayout(1, 4));
        painelInferior.add(btnOk);
        painelInferior.add(btnLimpar);
        painelInferior.add(btnMostrar);
        painelInferior.add(btnSair);

        btnOk.addActionListener(this);
        btnLimpar.addActionListener(this);
        btnMostrar.addActionListener(this);
        btnSair.addActionListener(this);

        setLayout(new BorderLayout());
        add(painelSuperior, BorderLayout.CENTER);
        add(painelInferior, BorderLayout.SOUTH);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == btnOk)
        {
            try
            {
                Aluno a = new Aluno();
                a.setUuid(UUID.randomUUID());
                a.setNome(txtNome.getText());
                a.setIdade(Integer.parseInt(txtIdade.getText()));
                a.setEndereco(txtEndereco.getText());
                alunos.add(a);
            }
            catch (Exception erro)
            {
                JOptionPane.showMessageDialog(this,
                    "Idade inválida: " + txtIdade.getText(),
                    "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        }
        else
            if (e.getSource() == btnLimpar)
            {
                txtNome.setText("");
                txtIdade.setText("");
                txtEndereco.setText("");
            }
            else
                if (e.getSource() == btnMostrar)
                {
                    String mensagem = "Resultado";
                    for (Aluno a : alunos)
                        mensagem += "\nId: " + a.getUuid() + "  Nome: " + a.getNome();
                    JOptionPane.showMessageDialog(this, mensagem);
                }
                else
                    if (e.getSource() == btnSair)
                    {
                        System.exit(0);
                    }
    }

    public static void main(String[] args)
    {
        new FormCadastroAluno();
    }
}
