package view;

import model.Lixeira;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class TelaPrincipal extends JFrame {
    private ArrayList<Lixeira> lixeiras;
    private Random random = new Random();

    public TelaPrincipal() {
        setTitle("Sistema de Coleta Sustentável");
        setSize(900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTabbedPane abas = new JTabbedPane();
        abas.addTab("Mapa da Cidade", criarPainelMapa());
        abas.addTab("Estatísticas", criarPainelEstatisticas());
        abas.addTab("Locais de Coleta", criarPainelLocaisColeta());
        abas.addTab("Configurações", criarPainelConfiguracoes());

        add(abas);
    }

    private JPanel criarPainelMapa() {
        JPanel painel = new JPanel(new BorderLayout());
        painel.setBackground(Color.LIGHT_GRAY);

        // Criar um mapa simplificado como fundo
        JPanel mapaPanel = new JPanel(null) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Desenha um mapa simplificado
                g.setColor(new Color(200, 255, 200)); // Cor de fundo do mapa
                g.fillRect(0, 0, getWidth(), getHeight());
                
                // Desenha ruas principais
                g.setColor(Color.GRAY);
                g.fillRect(100, 150, 600, 30);  // Rua horizontal principal
                g.fillRect(350, 50, 30, 400);   // Rua vertical principal
                
                // Desenha pontos de referência
                g.setColor(Color.BLUE);
                g.fillOval(120, 100, 30, 30);    // Parque
                g.fillOval(500, 80, 30, 30);    // Shopping
                g.fillOval(300, 250, 30, 30);    // Prefeitura
            }
        };
        mapaPanel.setPreferredSize(new Dimension(800, 500));
        
        // Adiciona pontos de coleta interativos
        String[] locais = {"Centro", "Zona Norte", "Zona Sul", "Zona Leste"};
        Color[] cores = {Color.RED, Color.ORANGE, Color.GREEN, Color.MAGENTA};
        int[][] posicoes = {{350, 150}, {200, 100}, {500, 200}, {350, 300}};
        
        for (int i = 0; i < locais.length; i++) {
            JButton ponto = new JButton();
            ponto.setBounds(posicoes[i][0], posicoes[i][1], 20, 20);
            ponto.setBackground(cores[i]);
            ponto.setOpaque(true);
            ponto.setBorderPainted(false);
            ponto.setToolTipText("Ponto de coleta: " + locais[i]);
            
            final String local = locais[i];
            ponto.addActionListener(e -> {mostrarDetalhesLocal(local);});
            
            mapaPanel.add(ponto);
            
            // Adiciona label
            JLabel label = new JLabel(locais[i]);
            label.setBounds(posicoes[i][0] + 25, posicoes[i][1], 100, 20);
            mapaPanel.add(label);
        }
        
        // Legenda
        JPanel legenda = new JPanel(new FlowLayout(FlowLayout.LEFT));
        legenda.add(new JLabel("Legenda: "));
        for (int i = 0; i < locais.length; i++) {
            JPanel itemLegenda = new JPanel();
            itemLegenda.add(new JLabel(new ColorIcon(cores[i], 15, 15)));
            itemLegenda.add(new JLabel(locais[i]));
            legenda.add(itemLegenda);
            legenda.add(Box.createHorizontalStrut(15));
        }
        
        painel.add(mapaPanel, BorderLayout.CENTER);
        painel.add(legenda, BorderLayout.SOUTH);
        
        return painel;
    }

    // Classe auxiliar para ícones coloridos na legenda
    class ColorIcon implements Icon {
        private Color color;
        private int width;
        private int height;
        
        public ColorIcon(Color color, int width, int height) {
            this.color = color;
            this.width = width;
            this.height = height;
        }
        
        @Override
        public void paintIcon(Component c, Graphics g, int x, int y) {
            g.setColor(color);
            g.fillOval(x, y, width, height);
        }
        
        @Override
        public int getIconWidth() { return width; }
        
        @Override
        public int getIconHeight() { return height; }
    }

    private JPanel criarPainelEstatisticas() {
        JPanel painel = new JPanel();
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));

        // Título
        JLabel titulo = new JLabel("Estatísticas de Coleta Diária");
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        painel.add(titulo);

        painel.add(Box.createRigidArea(new Dimension(0, 20)));

        // Quantidade total
        int total = random.nextInt(1000) + 500;
        JLabel totalLabel = new JLabel("Total recolhido hoje: " + total + " kg");
        totalLabel.setFont(new Font("Arial", Font.BOLD, 16));
        totalLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        painel.add(totalLabel);

        painel.add(Box.createRigidArea(new Dimension(0, 30)));

        // Categorias
        String[] categorias = {"Orgânico", "Reciclável", "Eletrônico", "Perigoso"};
        int[] quantidades = new int[4];
        int soma = 0;
        
        for (int i = 0; i < 3; i++) {
            quantidades[i] = random.nextInt(total / 2);
            soma += quantidades[i];
        }
        quantidades[3] = total - soma; // Garante que a soma seja igual ao total

        for (int i = 0; i < categorias.length; i++) {
            JPanel linha = new JPanel();
            linha.setLayout(new BoxLayout(linha, BoxLayout.X_AXIS));
            linha.setMaximumSize(new Dimension(400, 30));
            
            JLabel labelCategoria = new JLabel(categorias[i] + ":");
            labelCategoria.setPreferredSize(new Dimension(100, 20));
            
            JProgressBar barra = new JProgressBar(0, total);
            barra.setValue(quantidades[i]);
            barra.setStringPainted(true);
            barra.setString(quantidades[i] + " kg");
            
            linha.add(labelCategoria);
            linha.add(Box.createRigidArea(new Dimension(10, 0)));
            linha.add(barra);
            
            painel.add(linha);
            painel.add(Box.createRigidArea(new Dimension(0, 10)));
        }

        return painel;
    }

    private JPanel criarPainelLocaisColeta() {
        JPanel painel = new JPanel(new GridLayout(2, 2, 20, 20));
        painel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        String[] locais = {"Centro", "Zona Norte", "Zona Sul", "Zona Leste"};
        
        for (String local : locais) {
            JButton botao = new JButton(local);
            botao.setFont(new Font("Arial", Font.BOLD, 16));
            botao.addActionListener(e -> mostrarDetalhesLocal(local));
            painel.add(botao);
        }

        return painel;
    }

    private void mostrarDetalhesLocal(String local) {
        JFrame detalhesFrame = new JFrame("Detalhes do Local: " + local);
        detalhesFrame.setSize(500, 400);
        detalhesFrame.setLocationRelativeTo(this);

        JPanel painel = new JPanel();
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
        painel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Informações aleatórias
        int coletadoHoje = random.nextInt(200) + 50;
        int coletadoSemana = random.nextInt(1000) + 200;
        String[] categorias = {"Orgânico", "Reciclável", "Eletrônico", "Perigoso"};
        
        JLabel titulo = new JLabel("Local: " + local);
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        painel.add(titulo);

        painel.add(Box.createRigidArea(new Dimension(0, 20)));

        JLabel lblHoje = new JLabel("Coletado hoje: " + coletadoHoje + " kg");
        lblHoje.setFont(new Font("Arial", Font.PLAIN, 14));
        painel.add(lblHoje);

        JLabel lblSemana = new JLabel("Coletado esta semana: " + coletadoSemana + " kg");
        lblSemana.setFont(new Font("Arial", Font.PLAIN, 14));
        painel.add(lblSemana);

        painel.add(Box.createRigidArea(new Dimension(0, 20)));

        JLabel lblCategorias = new JLabel("Distribuição por categoria:");
        lblCategorias.setFont(new Font("Arial", Font.BOLD, 14));
        painel.add(lblCategorias);

        painel.add(Box.createRigidArea(new Dimension(0, 10)));

        for (String categoria : categorias) {
            int quantidade = random.nextInt(coletadoHoje / 2) + 10;
            JLabel lbl = new JLabel(categoria + ": " + quantidade + " kg");
            painel.add(lbl);
            painel.add(Box.createRigidArea(new Dimension(0, 5)));
        }

        painel.add(Box.createRigidArea(new Dimension(0, 20)));

        JButton btnFechar = new JButton("Fechar");
        btnFechar.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnFechar.addActionListener(e -> detalhesFrame.dispose());
        painel.add(btnFechar);

        detalhesFrame.add(painel);
        detalhesFrame.setVisible(true);
    }

    private JPanel criarPainelConfiguracoes() {
        JPanel painel = new JPanel();
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
        painel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JCheckBox notificacoes = new JCheckBox("Ativar notificações de coleta");
        JCheckBox modoEscuro = new JCheckBox("Modo escuro");

        painel.add(notificacoes);
        painel.add(Box.createRigidArea(new Dimension(0, 10)));
        painel.add(modoEscuro);

        return painel;
    }
}
