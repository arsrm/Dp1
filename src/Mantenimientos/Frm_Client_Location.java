/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mantenimientos;

import Model.Client;
import Simulacion_Algoritmica.Frm_Show_Route_Solution;
import dao.DaoClient;
import dao.impl.DaoClientImpl;
import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

/**
 *
 * @author Luis Miguel
 */
public class Frm_Client_Location extends javax.swing.JFrame {

    ImageIcon map;
    Frm_Client frm_clientAux;
    Frm_Distribution_Center frm_distributionAux;
    Integer posX = -1, posY = -1;
    Imagen imagen;
    int flag;
    DaoClient daoClient = new DaoClientImpl();
    Client cliente;

    public class Imagen extends javax.swing.JPanel {

        ImageIcon simbolo = null;

        Path path = Paths.get("Imagenes/mapWMS.png");

        BufferedImage imageMap;

        public Imagen(/*JPanel p*/) {
            byte[] data;
            try {
                data = Files.readAllBytes(path);
                imageMap = ImageIO.read(new ByteArrayInputStream(data));
                simbolo = new ImageIcon(imageMap.getScaledInstance(imageMap.getWidth(), imageMap.getHeight(), java.awt.Image.SCALE_SMOOTH));
                map = simbolo;
            } catch (IOException ex) {

            }
            this.setSize(imageMap.getWidth(), imageMap.getHeight()); //se selecciona el tamaño del panel
        }

        public void refresh() {
            simbolo = map;
        }

        //Se crea un método cuyo parámetro debe ser un objeto Graphics
        public void paint(Graphics grafico) {
            Dimension height = getSize();
            grafico.drawImage(simbolo.getImage(), 0, 0, simbolo.getIconWidth(), simbolo.getIconHeight(), null);
            if (posX != -1 && posY != -1) {
                Graphics2D g2 = (Graphics2D) grafico;
                g2.setStroke(new BasicStroke(10));
                g2.drawLine(posX, posY, posX, posY);
                grafico.setFont(grafico.getFont().deriveFont(12f));
                if (flag == 1) {
                    if(cliente == null)
                        grafico.drawString("CLIENTE NUEVO", posX, posY);
                    else
                        grafico.drawString(cliente.getName(),posX,posY);
                } else {
                    grafico.drawString("Centro de Distribuciòn", posX, posY);
                }
            }
            setOpaque(false);
            super.paintComponent(grafico);
        }
    }

    public Frm_Client_Location(Frm_Client frm_client, String posx, String posy, Integer idCliente) {
        frm_clientAux = frm_client;
        flag = 1;
        initComponents();
        cliente = daoClient.clientGet(idCliente);
        if (cliente != null) {
            if (posx.equals("") == false) { //si no es nuevo se setea la coordenada
                Double x = Double.parseDouble(posx);
                posX = Integer.valueOf(x.intValue());
            }
            if (posy.equals("") == false) {//si no es nuevo se setea la coordenada
                Double y = Double.parseDouble(posy);
                posY = Integer.valueOf(y.intValue());
            }
        }
        printMap(posX, posY);

    }

    public Frm_Client_Location(Frm_Client frm_client, String posx, String posy) {
        frm_clientAux = frm_client;
        
        flag = 1;
        initComponents();
        if (posx.equals("") == false) { //si no es nuevo se setea la coordenada
            Double x = Double.parseDouble(posx);
            posX = Integer.valueOf(x.intValue());
        }
        if (posy.equals("") == false) {//si no es nuevo se setea la coordenada
            Double y = Double.parseDouble(posy);
            posY = Integer.valueOf(y.intValue());
        }
        printMap(posX, posY);

    }

    public Frm_Client_Location(Frm_Distribution_Center frm_distribution, String posx, String posy) {
        frm_distributionAux = frm_distribution;
        flag = 0;
        initComponents();
        if (posx.equals("") == false) { //si no es nuevo se setea la coordenada
            Double x = Double.parseDouble(posx);
            posX = Integer.valueOf(x.intValue());
        }
        if (posy.equals("") == false) {//si no es nuevo se setea la coordenada
            Double y = Double.parseDouble(posy);
            posY = Integer.valueOf(y.intValue());
        }
        printMap(posX, posY);

    }

    private void printMap(Integer posx, Integer posy) {
        imagen = new Imagen();
        int width = imagen.simbolo.getIconWidth();
        int height = imagen.simbolo.getIconHeight();
        Dimension d = new Dimension();
        d.height = height;
        d.width = width;
        pnl_img.setPreferredSize(d);
        JScrollPane scroll = new JScrollPane(pnl_img);
        scroll.setBounds(10, 80, 1200, 600);
        scroll.setAutoscrolls(true);
        pnl_img.add(imagen);
        pnl_img.repaint();
        scroll.setViewportView(pnl_img);
        scroll.getViewport().setView(pnl_img);
        this.add(scroll);
        if (posx != -1 && posy != -1) {
            showPoint();
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_img = new javax.swing.JPanel();
        pnl_client = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbl_posX = new javax.swing.JLabel();
        lbl_posY = new javax.swing.JLabel();
        txt_posX = new javax.swing.JTextField();
        txt_posY = new javax.swing.JTextField();
        btn_Save = new javax.swing.JButton();
        btn_Clear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        pnl_img.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnl_imgMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnl_imgLayout = new javax.swing.GroupLayout(pnl_img);
        pnl_img.setLayout(pnl_imgLayout);
        pnl_imgLayout.setHorizontalGroup(
            pnl_imgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnl_imgLayout.setVerticalGroup(
            pnl_imgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 181, Short.MAX_VALUE)
        );

        pnl_client.setBorder(javax.swing.BorderFactory.createTitledBorder("Ubicación"));

        jLabel1.setText("Seleccione una posición en el mapa:");

        lbl_posX.setText("Pos. X:");

        lbl_posY.setText("Pos. Y:");

        txt_posX.setEditable(false);

        txt_posY.setEditable(false);

        javax.swing.GroupLayout pnl_clientLayout = new javax.swing.GroupLayout(pnl_client);
        pnl_client.setLayout(pnl_clientLayout);
        pnl_clientLayout.setHorizontalGroup(
            pnl_clientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_clientLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_clientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_clientLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnl_clientLayout.createSequentialGroup()
                        .addComponent(lbl_posX)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_posX, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_posY)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_posY, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        pnl_clientLayout.setVerticalGroup(
            pnl_clientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_clientLayout.createSequentialGroup()
                .addGroup(pnl_clientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_posX)
                    .addComponent(lbl_posY)
                    .addComponent(txt_posX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_posY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        btn_Save.setText("Guardar");
        btn_Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SaveActionPerformed(evt);
            }
        });

        btn_Clear.setText("Limpiar");
        btn_Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(pnl_img, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnl_client, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(599, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_Save, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btn_Clear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(38, 38, 38))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnl_client, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_img, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(btn_Clear)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Save)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pnl_imgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_imgMouseClicked
        // TODO add your handling code here:        
        posX = evt.getX();
        posY = evt.getY();
        showPoint();
    }//GEN-LAST:event_pnl_imgMouseClicked

    private void showPoint() {
        imagen.refresh();
        pnl_img.add(imagen);
        pnl_img.repaint();
        txt_posX.setText(posX.toString());
        txt_posY.setText(posY.toString());
        Graphics2D g2 = (Graphics2D) pnl_img.getGraphics();
        g2.setStroke(new BasicStroke(10));
        g2.drawLine(posX, posY, posX, posY);
        g2.setFont(g2.getFont().deriveFont(12f));
        g2.drawString("Centro de Distribución", posX, posY);
    }
    private void btn_SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SaveActionPerformed
        // TODO add your handling code here:
        Object[] options = {"OK"};
        if (txt_posX.getText().equals("") == true || txt_posY.getText().equals("") == true) {
            int ok_option = JOptionPane.showOptionDialog(new JFrame(), "Debe seleccionar una ubicación.", "Mensaje", JOptionPane.PLAIN_MESSAGE, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        } else {
            Integer x = Integer.parseInt(txt_posX.getText());
            Integer y = Integer.parseInt(txt_posY.getText());
            if (flag == 1) {
                frm_clientAux.fillPositions(x, y);
                frm_clientAux.setVisible(true);
                this.dispose();
            } else {
                frm_distributionAux.fillPositions(x, y);
                frm_distributionAux.setVisible(true);
                this.dispose();
            }

        }


    }//GEN-LAST:event_btn_SaveActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        if (flag == 1) {
            frm_clientAux.setVisible(true);
        } else {
            frm_distributionAux.setVisible(true);
        }
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private void btn_ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ClearActionPerformed
        // TODO add your handling code here:
        
        if (txt_posX.getText().equals("") == true || txt_posY.getText().equals("") == true) {
           JOptionPane.showMessageDialog(this, "No se ha seleccionado ninguna ubicacion");
        } else {
            imagen.refresh();
            pnl_img.add(imagen);
            pnl_img.repaint();
            posX = -1;
            posY = -1;
            txt_posX.setText("");
            txt_posY.setText("");
        }
    }//GEN-LAST:event_btn_ClearActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Clear;
    private javax.swing.JButton btn_Save;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbl_posX;
    private javax.swing.JLabel lbl_posY;
    private javax.swing.JPanel pnl_client;
    private javax.swing.JPanel pnl_img;
    private javax.swing.JTextField txt_posX;
    private javax.swing.JTextField txt_posY;
    // End of variables declaration//GEN-END:variables
}
