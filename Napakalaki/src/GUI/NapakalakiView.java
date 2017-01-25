/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import NapakalakiGame.CombatResult;
import NapakalakiGame.Napakalaki;

/**
 *
 * @author Adri
 */
public class NapakalakiView extends javax.swing.JFrame {
    Napakalaki napakalakiModel;
    boolean battle = false;
    
    /**
     * Creates new form NapakalakiView
     */
    public NapakalakiView() {
        initComponents();
        this.Close.setVisible(false);
    }
    
    public void setNapakalaki(Napakalaki n){
        napakalakiModel = n;
        this.currentPlayer.setPlayer(n.getCurrentPlayer());
        this.currentPlayer.setNapakalaki(n);
        this.currentMonster.setMonster(n.getCurrentMonster());
        this.currentPlayer.setEnabledMakeVisible(true);
        this.currentPlayer.setEnabledDiscardAll(false);
        this.currentPlayer.setEnabledDiscardTreasure(false);
        this.currentPlayer.setEnabledStealTreasure(false);
        this.currentMonster.setVisible(false);
        this.Combat.setEnabled(false);
        this.NextTurn.setEnabled(false);
        messageCleaning();
        repaint();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        currentPlayer = new GUI.PlayerView();
        currentMonster = new GUI.MonsterView();
        jPanel1 = new javax.swing.JPanel();
        NextTurn = new javax.swing.JButton();
        mensaje1 = new javax.swing.JLabel();
        MeetMonster = new javax.swing.JButton();
        Combat = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        mensaje2 = new javax.swing.JLabel();
        Close = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        currentPlayer.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2), "Jugador actual", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Consolas", 1, 12))); // NOI18N

        currentMonster.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2), "Monstruo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Consolas", 1, 12))); // NOI18N

        NextTurn.setText("Siguiente Turno");
        NextTurn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextTurnActionPerformed(evt);
            }
        });

        mensaje1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        mensaje1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        MeetMonster.setText("Ver Monstruo");
        MeetMonster.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MeetMonsterActionPerformed(evt);
            }
        });

        Combat.setText("Combatir");
        Combat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CombatActionPerformed(evt);
            }
        });

        jSeparator1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        mensaje2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        mensaje2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Close.setText("Cerrar");
        Close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(MeetMonster, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Combat, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(NextTurn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Close, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jSeparator1)
                    .addComponent(mensaje2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(mensaje1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mensaje1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mensaje2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MeetMonster)
                    .addComponent(Combat)
                    .addComponent(NextTurn)
                    .addComponent(Close))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(currentPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(currentMonster, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(currentPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(currentMonster, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(365, 365, 365)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(7, 7, 7))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MeetMonsterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MeetMonsterActionPerformed
        // TODO add your handling code here:
        this.currentPlayer.setEnabledMakeVisible(false);
        this.currentPlayer.setEnabledDiscardAll(true);
        this.currentPlayer.setEnabledDiscardTreasure(true);
        if (this.currentPlayer.getPlayer().canISteal())
            this.currentPlayer.setEnabledStealTreasure(true);
        this.currentMonster.setVisible(true);
        if (!battle)
            this.Combat.setEnabled(true);
        this.MeetMonster.setEnabled(false);
        repaint();
    }//GEN-LAST:event_MeetMonsterActionPerformed

    private void CombatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CombatActionPerformed
        // TODO add your handling code here: 
        CombatResult combatResult = napakalakiModel.developCombat();
        String m1 = "", m2 = "";
        
        switch(combatResult){
            case LOSE:
                m1 = "** Perdiste el combate **";
                m2 = "Toca cumplir el mal rollo";
                break;
            case WIN:
                m1 = "**   ¡¡Ganaste el combate!!   **";
                break;
            case LOSEANDCONVERT:
                m1 = "**   Perdiste el combate   **";
                m2 = "Quedas convertido en sectario";
                break;
            case WINGAME:
                m1 = "**    ¡¡ GANAS EL JUEGO !!    **";
                this.Combat.setVisible(false);
                this.MeetMonster.setVisible(false);
                this.NextTurn.setVisible(false);
                this.Close.setVisible(true);
                break;
        }
        
        battle = true;
        this.mensaje1.setText(m1);
        this.mensaje2.setText(m2);
        this.NextTurn.setEnabled(true);
        this.Combat.setEnabled(false);
        repaint();
    }//GEN-LAST:event_CombatActionPerformed

    private void NextTurnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextTurnActionPerformed
        // TODO add your handling code here:
        if (!napakalakiModel.nextTurn()){
            this.mensaje1.setText("**          ERROR            **");
            this.mensaje2.setText("Tienes mas de 4 tesoros ocultos");
        }
        else{
            this.NextTurn.setEnabled(false);
            this.MeetMonster.setEnabled(true);
            setNapakalaki(napakalakiModel);
        }
        
        battle = false;
        repaint();
    }//GEN-LAST:event_NextTurnActionPerformed

    private void CloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_CloseActionPerformed
                   
    public void showView(){
        this.setVisible(true);
    }
    
    private void messageCleaning(){
        this.mensaje1.setText("");
        this.mensaje2.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Close;
    private javax.swing.JButton Combat;
    private javax.swing.JButton MeetMonster;
    private javax.swing.JButton NextTurn;
    private GUI.MonsterView currentMonster;
    private GUI.PlayerView currentPlayer;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel mensaje1;
    private javax.swing.JLabel mensaje2;
    // End of variables declaration//GEN-END:variables
}
