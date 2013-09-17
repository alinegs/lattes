/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TelaPrincipal.java
 *
 * Created on Oct 25, 2011, 8:01:18 PM
 */

package projetolattes.telas;


import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.Toolkit;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import projetolattes.util.Main;
import projetolattes.util.Monitoramento;



/**
 * Frame da Tela Principal
 * @author Thatiany Lima e Aline Gonçalves
 */
public class TelaPrincipal extends javax.swing.JFrame {

    private static Logger log = Logger.getLogger(TelaPrincipal.class.getName());
    Color cor;

    /** 
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
        //Altera o ícone do frame da Tela Principal
        try{
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
            Image icon = Toolkit.getDefaultToolkit().getImage("src/projetolattes/imagens/professor.png");
            setIconImage(icon);
        }
        catch(Exception exp){
            exp.printStackTrace();
        }

        initComponents();
        setExtendedState(TelaPrincipal.MAXIMIZED_BOTH);
        // evita que sobreponha a barra do windows
        inserirFundo();
        addTela(new TelaLogin());
        enableMenus(false);
        enableButtons(false);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktop = new javax.swing.JDesktopPane();
        btnEmitirRelatorio = new javax.swing.JButton();
        btnCadastrarProfessor = new javax.swing.JButton();
        configurar = new javax.swing.JButton();
        btnConsultar = new javax.swing.JButton();
        barraMenu = new javax.swing.JMenuBar();
        menuCadastro = new javax.swing.JMenu();
        menuCadastrarProfessor = new javax.swing.JMenuItem();
        menuConsultar = new javax.swing.JMenu();
        menuConsultarProfessor = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItemIntervalo = new javax.swing.JMenuItem();
        menuRelatorio = new javax.swing.JMenu();
        menuRelatorioTodosProfessores = new javax.swing.JMenuItem();
        menuSair = new javax.swing.JMenu();
        menuItemSair = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(Main.recursos.getString("titulo.tela.principal"));
        setResizable(false);

        desktop.setBackground(new java.awt.Color(51, 51, 51));

        btnEmitirRelatorio.setFont(new java.awt.Font("Tahoma", 1, 11));
        btnEmitirRelatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetolattes/imagens/relatorio.png"))); // NOI18N
        btnEmitirRelatorio.setText(Main.recursos.getString("btnRelatorios.tela.principal"));
        btnEmitirRelatorio.setToolTipText("Relatórios e/ou gráficos sobre a produção dos professores.");
        btnEmitirRelatorio.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEmitirRelatorio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEmitirRelatorio.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEmitirRelatorio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEmitirRelatorioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEmitirRelatorioMouseExited(evt);
            }
        });
        btnEmitirRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmitirRelatorioActionPerformed(evt);
            }
        });
        btnEmitirRelatorio.setBounds(80, 500, 100, 70);
        desktop.add(btnEmitirRelatorio, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnCadastrarProfessor.setFont(new java.awt.Font("Tahoma", 1, 11));
        btnCadastrarProfessor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetolattes/imagens/cadastrar.png"))); // NOI18N
        btnCadastrarProfessor.setText(Main.recursos.getString("btnCadastro.tela.principal"));
        btnCadastrarProfessor.setToolTipText("Cadastro de Professores com seu respectivo link do curriculo lattes.");
        btnCadastrarProfessor.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCadastrarProfessor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCadastrarProfessor.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCadastrarProfessor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCadastrarProfessorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCadastrarProfessorMouseExited(evt);
            }
        });
        btnCadastrarProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarProfessorActionPerformed(evt);
            }
        });
        btnCadastrarProfessor.setBounds(80, 170, 100, 70);
        desktop.add(btnCadastrarProfessor, javax.swing.JLayeredPane.DEFAULT_LAYER);

        configurar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        configurar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetolattes/imagens/configuracao.png"))); // NOI18N
        configurar.setText(Main.recursos.getString("btnConfiguracoes.tela.principal"));
        configurar.setToolTipText("Configurações do sistema");
        configurar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        configurar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        configurar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        configurar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                configurarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                configurarMouseExited(evt);
            }
        });
        configurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                configurarActionPerformed(evt);
            }
        });
        configurar.setBounds(80, 390, 100, 70);
        desktop.add(configurar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnConsultar.setFont(new java.awt.Font("Tahoma", 1, 11));
        btnConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetolattes/imagens/consultar.png"))); // NOI18N
        btnConsultar.setText(Main.recursos.getString("btnConsulta.tela.principal"));
        btnConsultar.setToolTipText("Consultar produções, curriculo lattes dos professores.");
        btnConsultar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnConsultar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnConsultar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnConsultar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnConsultarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnConsultarMouseExited(evt);
            }
        });
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });
        btnConsultar.setBounds(80, 280, 100, 70);
        desktop.add(btnConsultar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        menuCadastro.setText(Main.recursos.getString("menuCadastro.tela.principal"));

        menuCadastrarProfessor.setText(Main.recursos.getString("menuItemCadastro.tela.principal"));
        menuCadastrarProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastrarProfessorActionPerformed(evt);
            }
        });
        menuCadastro.add(menuCadastrarProfessor);

        barraMenu.add(menuCadastro);

        menuConsultar.setText(Main.recursos.getString("menuConsulta.tela.principal"));

        menuConsultarProfessor.setText(Main.recursos.getString("menuItemConsulta.tela.principal"));
        menuConsultarProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuConsultarProfessorActionPerformed(evt);
            }
        });
        menuConsultar.add(menuConsultarProfessor);

        barraMenu.add(menuConsultar);

        jMenu3.setText(Main.recursos.getString("menuConfiguracoes.tela.principal"));

        jMenuItemIntervalo.setText(Main.recursos.getString("menuItemIntervalo.tela.principal"));
        jMenuItemIntervalo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemIntervaloActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItemIntervalo);

        barraMenu.add(jMenu3);

        menuRelatorio.setText(Main.recursos.getString("menuRelatorios.tela.principal"));

        menuRelatorioTodosProfessores.setText(Main.recursos.getString("menuItemRelatorio.tela.principal"));
        menuRelatorioTodosProfessores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRelatorioTodosProfessoresActionPerformed(evt);
            }
        });
        menuRelatorio.add(menuRelatorioTodosProfessores);

        barraMenu.add(menuRelatorio);

        menuSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetolattes/imagens/sairr.png"))); // NOI18N
        menuSair.setText(Main.recursos.getString("menuSair.tela.principal"));
        menuSair.setToolTipText("Sair do sistema");

        menuItemSair.setText(Main.recursos.getString("menuSair.tela.principal"));
        menuItemSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSairActionPerformed(evt);
            }
        });
        menuSair.add(menuItemSair);

        barraMenu.add(menuSair);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetolattes/imagens/Help.png"))); // NOI18N
        barraMenu.add(jMenu5);

        setJMenuBar(barraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Trata o evento do botão cadastrar professor
     * @param evt o evento
     */
    private void btnCadastrarProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarProfessorActionPerformed
        log.info(Main.recursos.getString("log.cadastro.professor"));
        //Insere a janela interna de cadastro de professor
        addTela(new TelaCadastroProfessor());
}//GEN-LAST:event_btnCadastrarProfessorActionPerformed


    /**
     * Trata o evento de mouse no botão cadastrar professor
     * @param evt O evento
     */
    private void btnCadastrarProfessorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCadastrarProfessorMouseEntered
        btnCadastrarProfessor.setBorderPainted(false);
}//GEN-LAST:event_btnCadastrarProfessorMouseEntered


    /**
     * Trata o evento de mouse no botão cadastrar professor
     * @param evt O evento
     */
    private void btnCadastrarProfessorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCadastrarProfessorMouseExited
        btnCadastrarProfessor.setBorderPainted(true);
}//GEN-LAST:event_btnCadastrarProfessorMouseExited

    /**
     * Trata o evento de mouse no botão consultar professor
     * @param evt O evento
     */
    private void btnConsultarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConsultarMouseEntered
        btnConsultar.setBorderPainted(false);
}//GEN-LAST:event_btnConsultarMouseEntered

    /**
     * Trata o evento de mouse no botão consultar professor
     * @param evt O evento
     */
    private void btnConsultarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConsultarMouseExited
        btnConsultar.setBorderPainted(true);
}//GEN-LAST:event_btnConsultarMouseExited

    /**
     * Trata o evento de mouse no botão configurações
     * @param evt O evento
     */
    private void configurarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_configurarMouseEntered
        configurar.setBorderPainted(false);
    }//GEN-LAST:event_configurarMouseEntered

    /**
     * Trata o evento de mouse no botão configuracoes
     * @param evt O evento
     */
    private void configurarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_configurarMouseExited
        configurar.setBorderPainted(true);
    }//GEN-LAST:event_configurarMouseExited

    /**
     * Trata o evento de mouse no botão relatorios
     * @param evt O evento
     */
    private void btnEmitirRelatorioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEmitirRelatorioMouseEntered
         btnEmitirRelatorio.setBorderPainted(false);
}//GEN-LAST:event_btnEmitirRelatorioMouseEntered

    /**
     * Trata o evento de mouse no botão relatorios
     * @param evt O evento
     */
    private void btnEmitirRelatorioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEmitirRelatorioMouseExited
        btnEmitirRelatorio.setBorderPainted(true);
}//GEN-LAST:event_btnEmitirRelatorioMouseExited

    /**
     * Trata o evento do botão consultar
     * @param evt O evento
     */
    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        log.info(Main.recursos.getString("log.consulta.professor"));
        //Insere a janela interna de consulta de professor
        addTela(new TelaConsulta());
}//GEN-LAST:event_btnConsultarActionPerformed

    /**
     * Trata o evento do botão emitirRelatorio
     * @param evt O evento
     */
    private void btnEmitirRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmitirRelatorioActionPerformed
        log.info(Main.recursos.getString("log.relatorios.professor"));
        //Isere a janela interna de emetir relatorio
        addTela(new TelaRelatorio());
}//GEN-LAST:event_btnEmitirRelatorioActionPerformed

    /**
     * Trata o evento do menu cadastrar professor
     * @param evt O evento
     */
    private void menuCadastrarProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastrarProfessorActionPerformed
        log.info(Main.recursos.getString("log.cadastro.professor"));
        //Insere a janela  interna de cadastro de professor
        addTela(new TelaCadastroProfessor());
}//GEN-LAST:event_menuCadastrarProfessorActionPerformed

    /**
     * Trata o evento do menu consultar professor
     * @param evt O evento
     */
    private void menuConsultarProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuConsultarProfessorActionPerformed
        log.info(Main.recursos.getString("log.consulta.professor"));
        //Insere a janela interna de consulta de professor
        addTela(new TelaConsulta());
    }//GEN-LAST:event_menuConsultarProfessorActionPerformed

    /**
     * Trata o evento do menu relatórios
     * @param evt O evento
     */
    private void menuRelatorioTodosProfessoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRelatorioTodosProfessoresActionPerformed
        log.info(Main.recursos.getString("log.relatorios.professor"));
        //Insere a janela interna de consulta de professor
        addTela(new TelaRelatorio());
    }//GEN-LAST:event_menuRelatorioTodosProfessoresActionPerformed

    /**
     * Trata o evento do menu Sair
     * @param evt O evento
     */
    private void menuItemSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemSairActionPerformed
        log.info(Main.recursos.getString("log.finalizando.monitoramento"));
        log.info(Main.recursos.getString("log.monitoramento.finalizado"));
        log.info(Main.recursos.getString("log.login.finalizado"));
        // Sai do sistema
        Runtime.getRuntime().exit(0);
}//GEN-LAST:event_menuItemSairActionPerformed

     /**
     * Trata o evento do menu Intervalo de monitoramento
     * @param evt O evento
     */
    private void jMenuItemIntervaloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemIntervaloActionPerformed

        log.info(Main.recursos.getString("log.alterar.tempoMonitoramento"));

        // Pergunta qual o intervalo de atualização
        String intervalo = JOptionPane.showInputDialog(Main.recursos.getString("txtTempo.principal.monitoramento"), Integer.toString(Monitoramento.getIntervalo()));
            try {
                Monitoramento.setIntervalo(Integer.parseInt(intervalo));
            } catch (Exception ex) {
                log.warning(Main.recursos.getString("log.monitoramento.erro"));
                JOptionPane.showMessageDialog(null,Main.recursos.getString("excecao.monitoramento.erro"),      Main.recursos.getString("txt.erro2.principal"),   JOptionPane.INFORMATION_MESSAGE);
            }
        Monitoramento m = new Monitoramento();
        m.start();
}//GEN-LAST:event_jMenuItemIntervaloActionPerformed

    /**
     * Trata o evento do menu Intervalo de monitoramento
     * @param evt O evento
     */
    private void configurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_configurarActionPerformed
         log.info(Main.recursos.getString("log.alterar.tempoMonitoramento"));

        // Pergunta qual o intervalo de atualização
        String intervalo = JOptionPane.showInputDialog(Main.recursos.getString("txtTempo.principal.monitoramento"), Integer.toString(Monitoramento.getIntervalo()));
            try {
                Monitoramento.setIntervalo(Integer.parseInt(intervalo));
            } catch (Exception ex) {
                log.warning(Main.recursos.getString("log.monitoramento.erro"));
                JOptionPane.showMessageDialog(null,Main.recursos.getString("excecao.monitoramento.erro"),      Main.recursos.getString("txt.erro2.principal"),   JOptionPane.INFORMATION_MESSAGE);
            }
        Monitoramento m = new Monitoramento();
        m.start();
    }//GEN-LAST:event_configurarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JMenuBar barraMenu;
    private javax.swing.JButton btnCadastrarProfessor;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnEmitirRelatorio;
    private javax.swing.JButton configurar;
    private static javax.swing.JDesktopPane desktop;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuItem jMenuItemIntervalo;
    private javax.swing.JMenuItem menuCadastrarProfessor;
    private javax.swing.JMenu menuCadastro;
    private javax.swing.JMenu menuConsultar;
    private javax.swing.JMenuItem menuConsultarProfessor;
    private javax.swing.JMenuItem menuItemSair;
    private javax.swing.JMenu menuRelatorio;
    private javax.swing.JMenuItem menuRelatorioTodosProfessores;
    private javax.swing.JMenu menuSair;
    // End of variables declaration//GEN-END:variables

    /**
     * Método para inserir a imagem de fundo
     */
    public void inserirFundo(){
        Icon imagem = new ImageIcon("src/projetolattes/imagens/fundo.jpg");
        JLabel lab = new JLabel();
        lab.setIcon(imagem);
        double alt = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        double larg = Toolkit.getDefaultToolkit().getScreenSize().getWidth();

        int altura = (int) alt;
        int largura = (int) larg;

        lab.setBounds(0,0,largura,altura);

        desktop.add(lab);
    }


    /**
     * Abre a janela requisitada pelo nome e trata das propriedades de iconização e maximização
     * @param f A Tela interna a ser aberta
     */
    private void addTela(javax.swing.JInternalFrame f){

        for (javax.swing.JInternalFrame fi : desktop.getAllFrames()) {
            // se uma janela semelhante estiver aberta
            if(fi.getClass().toString().equalsIgnoreCase(f.getClass().toString())){
                fi.moveToFront(); // traz janela para frente para facilitar a escolha
                 // Deixa selecionada
                try{
                    if(fi.isIcon())
                        fi.setIcon(false);
                    fi.setSelected(true);
                }
                catch (PropertyVetoException ex) {
                    log.warning(Main.recursos.getString("log.restauracao.janela") + f.getClass());
                    JOptionPane.showMessageDialog(null, Main.recursos.getString("txt.erro.principal"), Main.recursos.getString("txt.erro2.principal"),   JOptionPane.INFORMATION_MESSAGE);
                }
                return;

            }
        }
        centralizar(f);
        desktop.add(f); //adiciona na tela

        if(f instanceof TelaLogin){
            f.setVisible(true);
        }
        else
            try {
                //maximiza a janela interna
                f.setMaximum(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
            f.setVisible(true); // seta visivel
    }

    /**
     * Habilita ou desabilita os menus
     * @param habilitar Habilita ou não os menus
     */
    public static void enableMenus(boolean habilitar){
        Component[] menus = barraMenu.getComponents();
        for(int i = 0; i < menus.length; i++)
            if(menus[i] instanceof javax.swing.JMenu)
                ((javax.swing.JMenu)menus[i]).setEnabled(habilitar);
    }

    /**
     * Habilita ou desabilita os botoes do desktop
     * @param habilitar Habilita ou não os botões
     */
    public static void enableButtons(boolean habilitar){
        Component[] menus = desktop.getComponents();
        for(int i = 0; i < menus.length; i++)
            if(menus[i] instanceof javax.swing.JButton)
                ((javax.swing.JButton)menus[i]).setEnabled(habilitar);
    }

    /**
     * Posiciona um internal frame no centro da tela
     * @param fi A tela interna a ser pocisionada no dentro
     */
    public static void centralizar(javax.swing.JInternalFrame fi){
        // Centraliza apenas a tela de login =D
        if(fi instanceof TelaLogin)
            fi.setLocation(desktop.getWidth()/2+190, desktop.getHeight()/2);
    }

}