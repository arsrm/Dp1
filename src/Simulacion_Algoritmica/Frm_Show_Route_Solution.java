/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Simulacion_Algoritmica;

import Model.Client;
import Model.Distribution_Center;
import dao.DaoClient;
import dao.DaoDistributionCenter;
import dao.impl.DaoClientImpl;
import dao.impl.DaoDistributionCenterImpl;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Luis Miguel
 */
public class Frm_Show_Route_Solution extends javax.swing.JFrame {
    ImageIcon map ;
    Integer posX=-1, posY=-1;
    Imagen imagen;
    List<String> listPerSol;
    DaoClient daoClient = new DaoClientImpl();
    DaoDistributionCenter daoDB = new DaoDistributionCenterImpl();
    Integer flag = 0;
    public class Imagen extends javax.swing.JPanel {
            ImageIcon simbolo = null;
            String routes = null;
            Path path = Paths.get(".\\Imagenes\\test.png");
           
            BufferedImage imageMap;
            public Imagen() {
                byte[] data;
                try {
                    data = Files.readAllBytes(path);
                    imageMap = ImageIO.read(new ByteArrayInputStream(data));
                    simbolo = new ImageIcon(imageMap.getScaledInstance(imageMap.getWidth(),imageMap.getHeight(), java.awt.Image.SCALE_SMOOTH)); 
                    map = simbolo;
                } catch (IOException ex) {
                    
                }
                this.setSize(imageMap.getWidth(), imageMap.getHeight()); //se selecciona el tamaño del panel
                
            }
            
            public void refresh(){
                simbolo = map;
            }

    //Se crea un método cuyo parámetro debe ser un objeto Graphics

            public void paint(Graphics grafico) {
            Dimension height = getSize();
            grafico.drawImage(simbolo.getImage(), 0, 0,simbolo.getIconWidth(), simbolo.getIconHeight(), null);
          
            Graphics2D g2 = (Graphics2D) grafico;
            if(routes!=null){
                String[] clients = routes.split("-");
                int sizeRoute = clients.length;
                for(int i=0;i<sizeRoute;i++){
                 if(Integer.parseInt(clients[i])==0){
                    Distribution_Center dis = daoDB.distribution_centerGetQry().get(0);
                    Client finish = daoClient.clientGet(Integer.parseInt(clients[i+1]));
                    g2.drawLine(dis.getPos_x(),dis.getPos_y(),finish.getPos_x(),finish.getPos_y());
                    g2.drawString(finish.getName(),finish.getPos_x(),finish.getPos_y());
                    g2.drawLine(finish.getPos_x(),finish.getPos_y(),finish.getPos_x(),finish.getPos_y());
                }else if(i==sizeRoute-2){
                     Client start = daoClient.clientGet(Integer.parseInt(clients[i]));
                     Distribution_Center dis = daoDB.distribution_centerGetQry().get(0);
                     g2.drawLine(start.getPos_x(),start.getPos_y(),dis.getPos_x(),dis.getPos_y());
                     g2.drawString(dis.getName(),dis.getPos_x(),dis.getPos_y());
                     g2.drawLine(dis.getPos_x(),dis.getPos_y(),dis.getPos_x(),dis.getPos_y());
                     break;

                }else{
                    Client start = daoClient.clientGet(Integer.parseInt(clients[i]));
                    Client finish = daoClient.clientGet(Integer.parseInt(clients[i+1]));
                    g2.drawLine(start.getPos_x(),start.getPos_y(),finish.getPos_x(),finish.getPos_y());
                    g2.drawString(finish.getName(),finish.getPos_x(),finish.getPos_y());
                    g2.drawLine(finish.getPos_x(),finish.getPos_y(),finish.getPos_x(),finish.getPos_y());
                 }
                }   
            }
           
            setOpaque(false);
            super.paintComponent(grafico);
        }
    }
    
    Frm_Algorithmic_Simulator frm_asAux = new Frm_Algorithmic_Simulator();
    BufferedImage imageMap;
    /**
     * Creates new form Frm_Show_Route_Solution
     */
    public Frm_Show_Route_Solution(Frm_Algorithmic_Simulator frm_as) throws IOException {
        frm_asAux=frm_as;
        setTitle("VISUALIZACIÓN DE LA RUTA");
        initComponents();
        //printMap(posX,posY);
    }
    
    public Frm_Show_Route_Solution(Frm_Algorithmic_Simulator frm_as,List<String> solutionsPerList) throws IOException {
        frm_asAux=frm_as;
        setTitle("VISUALIZACIÓN DE LA RUTA");
        initComponents();
        listPerSol = solutionsPerList;
        initializeCombo();
        printMap();
        
        showRoute(solutionsPerList.get(0));
        
    }
    
    private void initializeCombo(){
        int size = listPerSol.size();
        
        for(int i=0;i<size;i++){
            String item = "RUTA VEHICULO " + i;
            
            cbo_vehicles.addItem(item);
        }
       
        
        
        
    }
    
     

     private void printMap(){
        imagen = new Imagen();
        int width = imagen.simbolo.getIconWidth();
        int height = imagen.simbolo.getIconHeight();
        Dimension d = new Dimension();
        d.height = height;
        d.width = width;
        pnl_img.setPreferredSize(d);
        JScrollPane scroll = new JScrollPane(pnl_img);        
        scroll.setBounds(10,80,1200,600);        
        scroll.setAutoscrolls(true);
        pnl_img.add(imagen);
        pnl_img.repaint();
        scroll.setViewportView(pnl_img);
        scroll.getViewport().setView(pnl_img); 
        this.add(scroll);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        brn_exit = new javax.swing.JButton();
        lbl_select_vehicle = new javax.swing.JLabel();
        cbo_vehicles = new javax.swing.JComboBox();
        pnl_img = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        brn_exit.setText("Atrás");
        brn_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brn_exitActionPerformed(evt);
            }
        });

        lbl_select_vehicle.setText("Seleccionar Vehículo");

        cbo_vehicles.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbo_vehiclesItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout pnl_imgLayout = new javax.swing.GroupLayout(pnl_img);
        pnl_img.setLayout(pnl_imgLayout);
        pnl_imgLayout.setHorizontalGroup(
            pnl_imgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 697, Short.MAX_VALUE)
        );
        pnl_imgLayout.setVerticalGroup(
            pnl_imgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 364, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lbl_select_vehicle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbo_vehicles, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 269, Short.MAX_VALUE)
                .addComponent(brn_exit)
                .addContainerGap(273, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_img, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_select_vehicle)
                    .addComponent(cbo_vehicles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(brn_exit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_img, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void brn_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brn_exitActionPerformed
        // TODO add your handling code here:
        frm_asAux.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_brn_exitActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        frm_asAux.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private void cbo_vehiclesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbo_vehiclesItemStateChanged
        // TODO add your handling code here:
        if(flag==0){
            flag=1;
        }else{
            int indexVehicleList = cbo_vehicles.getSelectedIndex();
            String solutionForVehicle = listPerSol.get(indexVehicleList);
            showRoute(solutionForVehicle);
        }
        
    }//GEN-LAST:event_cbo_vehiclesItemStateChanged

    private void showRoute(String sol){
        //imagen = new Imagen();
        imagen.refresh();
        imagen.routes = sol;
        pnl_img.add(imagen);
        pnl_img.repaint();
         Graphics2D g2 = (Graphics2D) pnl_img.getGraphics();
         imagen.routes = sol;
         String[] clients = sol.split("-");
            int sizeRoute = clients.length;
            for(int i=0;i<sizeRoute;i++){
             if(Integer.parseInt(clients[i])==0){
                Distribution_Center dis = daoDB.distribution_centerGetQry().get(0);
                Client finish = daoClient.clientGet(Integer.parseInt(clients[i+1]));
                g2.drawLine(dis.getPos_x(),dis.getPos_y(),finish.getPos_x(),finish.getPos_y());
                g2.drawString(finish.getName(),finish.getPos_x(),finish.getPos_y());
                g2.drawLine(finish.getPos_x(),finish.getPos_y(),finish.getPos_x(),finish.getPos_y());
            }else if(i==sizeRoute-2){
                 Client start = daoClient.clientGet(Integer.parseInt(clients[i]));
                 Distribution_Center dis = daoDB.distribution_centerGetQry().get(0);
                 g2.drawLine(start.getPos_x(),start.getPos_y(),dis.getPos_x(),dis.getPos_y());
                 g2.drawString(dis.getName(),dis.getPos_x(),dis.getPos_y());
                 g2.drawLine(dis.getPos_x(),dis.getPos_y(),dis.getPos_x(),dis.getPos_y());
                 break;
                 
            }else{
                Client start = daoClient.clientGet(Integer.parseInt(clients[i]));
                Client finish = daoClient.clientGet(Integer.parseInt(clients[i+1]));
                g2.drawLine(start.getPos_x(),start.getPos_y(),finish.getPos_x(),finish.getPos_y());
                g2.drawString(finish.getName(),finish.getPos_x(),finish.getPos_y());
                g2.drawLine(finish.getPos_x(),finish.getPos_y(),finish.getPos_x(),finish.getPos_y());
             }
        }
        
    }
   
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton brn_exit;
    private javax.swing.JComboBox cbo_vehicles;
    private javax.swing.JLabel lbl_select_vehicle;
    private javax.swing.JPanel pnl_img;
    // End of variables declaration//GEN-END:variables
}
