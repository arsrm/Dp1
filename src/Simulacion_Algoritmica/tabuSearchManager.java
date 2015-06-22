/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Simulacion_Algoritmica;

import Model.Client;
import Model.Vehicle;
import java.io.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luis
 */
public class tabuSearchManager {
    
    private  List<Vehicle> vehicleList = new ArrayList<>(); //--> LISTA DE CAMIONES
    private  List<Client> clientList = new ArrayList<>(); //---> LISTA DE CLIENTES

    /**
     * @param aVehicleList the vehicleList to set
     */
    public  void setVehicleList(List<Vehicle> aVehicleList) {
        vehicleList = aVehicleList;
    }
    private ArrayList<Integer> initialSolution = new ArrayList<>();//---> SOLUCION INICIAL
    private double [][] distances;//---> MATRIZ DE COSTO (DE PUNTO A PUNTO)
    private int stoppingCriterion;//---> CRITERIO DE PARADA
    private int maxSizeTL = 10; //---> TAMAÑO MAXIMO DE LA LISTA TABU
    private int maxNumbIteration =10; //--->NUMERO MAXIMO DE ITERACIONES PENALIZADAS POR SOLUCION.
    private int neighborpivot = 1;
    
    
    public tabuSearchManager(){
        
    }
    
    public tabuSearchManager(List<Vehicle> vecList,List<Client> cliList,Integer stop){
        this.vehicleList = vecList;
        this.clientList = cliList;
        this.stoppingCriterion = stop;
        this.distances = getDistancesMatrix();
    }
    
    
    /**
     * @return the routesCost
     */
    public double[][] getDistances() {
        return distances;
    }

    /**
     * @param routesCost the routesCost to set
     */
    public void setDistances(double[][] distances) {
        this.distances = distances;
    }
    
    public class neighborElement{
        private int[] neighbor;

        public neighborElement(int[] neighbor){
            this.neighbor = neighbor;
        }
        /**
         * @return the neighbors
         */
        public int[] getNeighbor() {
            return neighbor;
        }

        /**
         * @param neighbors the neighbors to set
         */
        public void setNeighbor(int[] neighbor) {
            this.neighbor = neighbor;
        }
    }
    
    public class tabuElement{
        
        private ArrayList<Integer> tabuSolution;
        private int iterationNumb; 
        
        public tabuElement(){
            
        }
        
        public tabuElement(ArrayList<Integer> tabuSol){
            this.tabuSolution = tabuSol;
            this.iterationNumb = maxNumbIteration;
        }

       
        /**
         * @return the iterationNumb
         */
        public int getIterationNumb() {
            return iterationNumb;
        }

        /**
         * @param iterationNumb the iterationNumb to set
         */
        public void setIterationNumb(int iterationNumb) {
            this.iterationNumb = iterationNumb;
        }

        /**
         * @return the tabuSolution
         */
        public ArrayList<Integer> getTabuSolution() {
            return tabuSolution;
        }

        /**
         * @param tabuSolution the tabuSolution to set
         */
        public void setTabuSolution(ArrayList<Integer> tabuSolution) {
            this.tabuSolution = tabuSolution;
        }
        
        
        
    }
    
    public class solutionElement{
        private ArrayList<Integer> routes;
        private double cost;
        
        public solutionElement(){
            
        }

        public solutionElement(ArrayList<Integer> routes,double cost){
            this.routes=routes;
            this.cost = cost;
        }
        
       
        /**
         * @return the cost
         */
        public double getCost() {
            return cost;
        }

        /**
         * @param cost the cost to set
         */
        public void setCost(double cost) {
            this.cost = cost;
        }

        /**
         * @return the routes
         */
        public ArrayList<Integer> getRoutes() {
            return routes;
        }

        /**
         * @param routes the routes to set
         */
        public void setRoutes(ArrayList<Integer> routes) {
            this.routes = routes;
        }
        
    }
    
    public double[][] getDistancesMatrix(){
        int sizeClient = getClientList().size();
        double[][]distances =  new double[sizeClient][sizeClient];
        double[][]costs = new double[sizeClient][sizeClient];
        Client client1=null;
        Client client2=null;
        
            for(int i=0;i<sizeClient;i++){
                for(int j=0;j<sizeClient;j++){
                    if(i==j){
                        distances[i][j]=0;
                        costs[i][j]=0;
                    }
                    else{
                        client1 = getClientList().get(i);//cliente i
                        client2 = getClientList().get(j);//cliente j
                        //extraemos las coordenadas
                        int client1x = client1.getPos_x();
                        int client1y = client1.getPos_y();
                        int client2x = client2.getPos_x();
                        int client2y = client2.getPos_y();
                        //calculamos la distancia
                        double distance = (double)Math.round(Math.pow(Math.pow(client1x-client2x,2)+Math.pow(client1y-client2y,2),0.5)*100)/100;
                        distances[i][j]= distance;
                    } 
                }
            }
            for(int i=0;i<sizeClient;i++){
                System.out.println("");
                for(int j=0;j<sizeClient;j++){
                    System.out.print(distances[i][j]+"\t");
                }
            }
            return distances;
    }
    
    public double[][] getDistancesMatrixPerRoute(List<Client> list){
        int sizeClient = list.size();
        double[][]distances =  new double[sizeClient][sizeClient];
        double[][]costs = new double[sizeClient][sizeClient];
        Client client1=null;
        Client client2=null;
        
            for(int i=0;i<sizeClient;i++){
                for(int j=0;j<sizeClient;j++){
                    if(i==j){
                        distances[i][j]=0;
                        costs[i][j]=0;
                    }
                    else{
                        client1 = list.get(i);//cliente i
                        client2 = list.get(j);//cliente j
                        //extraemos las coordenadas
                        int client1x = client1.getPos_x();
                        int client1y = client1.getPos_y();
                        int client2x = client2.getPos_x();
                        int client2y = client2.getPos_y();
                        //calculamos la distancia
                        double distance = (double)Math.round(Math.pow(Math.pow(client1x-client2x,2)+Math.pow(client1y-client2y,2),0.5)*100)/100;
                        distances[i][j]= distance;
                    } 
                }
            }
            for(int i=0;i<sizeClient;i++){
                System.out.println("");
                for(int j=0;j<sizeClient;j++){
                    System.out.print(distances[i][j]+"\t");
                }
            }
                
            return distances;
    }
    
    public ArrayList<Integer> generateInitialSolution(){
        /*el algoritmo consiste en extraer un algoritmo voraz,
        pero luego se crea moviendo la primera solucion como el 2do el mejor, 3ero el mejor,etc
        */
        ArrayList<Integer> firstSolution = generateFirstBestSolution(0);
        int sizeFirstSolution = firstSolution.size();
        double initialCost = calculateFunctionCost(firstSolution);
        int clientsNumb = getClientList().size()-1;
        int maxSizeSolution = clientsNumb+clientsNumb+1;
        Integer[][] solutions = new Integer[clientsNumb][maxSizeSolution];
        //poner todas las soluciones de nuevo en estado de orden en no atendida a excepcion del primer cliente.
        for(int i=0;i<sizeFirstSolution;i++){
            solutions[0][i]=firstSolution.get(i);
        }
        for(int i=1;i<clientsNumb;i++){
            //regresamos a todos los clientes con pedidos no atendidos.
            for(int j=0;j<sizeFirstSolution;j++){
                if(j>0){
                    int index = getClientIndex(solutions[0][j]);
                    if(getClientList().get(index).getIdClient()!=0){
                        getClientList().get(index).setRequestState(0);
                    }
                }
            }
            //tenemos los clientes en estado en 0, elegimos al siguiente mejor
            ArrayList<Integer> bestSolution = generateFirstBestSolution(i);
            double bestCost = calculateFunctionCost(bestSolution);
            int sizeBestSolution = bestSolution.size();
            for(int z=0;z<sizeBestSolution;z++){
               solutions[i][z]=bestSolution.get(z);
            }
            //REINICIAR TODOS LOS USUARIOS EN ESTADO NO ATENDIDO
             for(int j=0;j<sizeFirstSolution;j++){
                if(j>0){
                    if(solutions[i][j]!=null){
                        int index = getClientIndex(solutions[i][j]);
                        if(getClientList().get(index).getIdClient()!=0){
                            getClientList().get(index).setRequestState(0);
                        }
                    }
                }
            }
        }
        //buscaremos la mejor de todas las posibles soluciones iniciales
        int bestIndex = -1;
        double bestCost = -1;
        boolean firstTime = true;        
        for(int i=0;i<clientsNumb;i++){//por cada solucion 
            ArrayList<Integer> solution = new ArrayList<>();//creamos el arraylist
            for(int j=0;j<maxSizeSolution;j++){
                solution.add(solutions[i][j]);
            }
            double actualCost = calculateFunctionCost(solution); //calculamos su costo
            if(firstTime ==true){ //si es la solucion inicial, sera nuestro mejor provisorio
                firstTime = false;
                bestCost = actualCost;
                bestIndex = i;
            }else{ //en caso que no es el primero, verificamos si es mejor que el menor
                if(actualCost<bestCost){
                    bestCost = actualCost;
                    bestIndex = i;
                }
            }
        }
        ArrayList<Integer> bestSolution = new ArrayList<Integer>();
        for(int j=0;j<maxSizeSolution;j++){
            bestSolution.add(solutions[bestIndex][j]);
        }
        bestSolution = reducedSizeSolution(bestSolution);
        return bestSolution;
    }
    
    public ArrayList<Integer> reducedSizeSolution(ArrayList<Integer> solution){
        //FUNCION QUE REDUCE EL TAMAÑO DE LA SOLUCION ELIMINANDO LOS VALORES NULL.
        ArrayList<Integer> reducedSolution = new ArrayList<>();
        int size = solution.size();
        for(int i=0;i<size;i++){
            if(solution.get(i)!=null)
                reducedSolution.add(solution.get(i));
        }
        return reducedSolution;
    }
    
    public int countNoClientsAttended(){
        int size = getClientList().size();
        int count = 0;
        for(int i=0;i<size;i++){
            if(getClientList().get(i).getRequestState()==0)
                count++;
        }
        return count;
    }
    
    public ArrayList<Integer> generateFirstBestSolution(int position){
        ArrayList<Integer> initialSol = new ArrayList<>();
        int sizeVehicules = getVehicleList().size();
        int sizeClients = getClientList().size();
        boolean allClientsServed = false;
        double usedCapacity;
        double freeCapacity;
        double actualRouteCost;
        int pivot;
        boolean firstTime = true;
        int nextClientIndex;
        double distanciaRecorrida;
        //por cada vehiculo, le asignamos sus clientes respectivos, no necesariamente todos los vehiculos
        //tendran un cliente(s) asignados.
        for(int i=0;i<sizeVehicules;i++){
            //1) verificamos si hay aun clientes atendidos.
            pivot = 0;
            distanciaRecorrida = 0.0;
            usedCapacity = 0;
            actualRouteCost =0;
            freeCapacity = getVehicleList().get(i).getCapacity();
            getVehicleList().get(i).setAvailableCapacity(freeCapacity);
            allClientsServed = verifyClientsServed();
            getVehicleList().get(i).setRoute(new ArrayList<Integer>());
            if(allClientsServed==false){//si todos los clientes aun no son atendidos, este vehiculo se activa
               initialSol.add(0);//iniciamos con el CD
               getVehicleList().get(i).getRoute().add(0);
              //pivote 0 indica el punto de partida que es el CD
               for(int j=0;j<sizeClients;j++){//buscamos al siguiente cliente próximo
                    if(firstTime ==true){//si es el primer cliente
                        if(position==0){
                              nextClientIndex = searchBestNextClient(pivot,i);//-->buscamos el siguiente 1er mejor cliente.
                        }else{
                             nextClientIndex = searchNBestNextClient(pivot,position,i);//-->buscamos el siguiente N mejor cliente.
                        }
                        firstTime = false;
                    }
                    else{
                        //seguimos buscando al siguiente 1er mejor por cada siguiente cliente.
                        nextClientIndex = searchBestNextClient(pivot,i);
                    }
                        if(nextClientIndex!=-1){
                            double actualRoute = calculateCostPerArist( pivot, nextClientIndex, i, freeCapacity );
                            actualRouteCost += actualRoute;
                            distanciaRecorrida=distances[pivot][nextClientIndex];
                            //para ponerlo en el camion verificamos que si hay capacidad para poner el pedido
                            if(getClientList().get(nextClientIndex).getTotalWeight()<=freeCapacity){//si hay espacio, lo inserto
                                //como se puede adicionar tambien se debe evitar el problema de la mariposa
                                if(pivot!=0){//no voy a verificar este problema si es que aun me encuentro en el CD
                                    double directDistance = distances[0][nextClientIndex];
                                    double directRoute = calculateCostPerArist(0,nextClientIndex,i,freeCapacity);
                                    if(actualRoute>directRoute && i!=sizeVehicules-1){//si me resulta ir mejor con un nuevo vehiculo
                                      break;  
                                    }
                                }
                                initialSol.add(getClientList().get(nextClientIndex).getIdClient());//lo añado a la lista                        
                                usedCapacity = getClientList().get(nextClientIndex).getTotalWeight();//capacidad usada
                                freeCapacity -= usedCapacity;//capacidad actual libre/disponible
                                getVehicleList().get(i).setAvailableCapacity(freeCapacity);
                                getClientList().get(nextClientIndex).setRequestState(1);//ya fue atendido
                                getVehicleList().get(i).getRoute().add(getClientList().get(nextClientIndex).getIdClient());
                                pivot = nextClientIndex;//es el nuevo punto para seguir avanzando
                            }else{ //si es mayor que la capacidad disponible, no se puede poner
                                break;
                            }
                        }else{
                            break;
                        }
                }
            }
        }
        initialSol.add(0);
        return initialSol;
    }
    
    public double calculateCostPerArist(int pivot, int next,int posVecList,double freeCapacity ){
        double cost = 0;
        Vehicle v =  getVehicleList().get(posVecList);
        double factor1 = (v.getDispatchNumber()*1.0)*(getClientList().get(next).getPriority()*1.0);
        double factor2 = 1.0;
        cost=(Double)((factor1)*distances[pivot][next]*(factor2)/1000.0);
        return cost;
    }
    
    public int searchNBestNextClient(int pivot,int position,int veh){
        //FUNCION QUE RETORNA EL INDICE DEL SIGUIENTE MEJOR N° CLIENTE.
        //si position=0 --> 1er mejor
        //si position=1 --> 2do mejor
        //si position=2 --> 3er mejor
        //asi sucesivamente
        int sizeClients = getClientList().size();
        int bestIndex=-1;
        boolean firstTime = true;
        double[] costRoutes = new double[sizeClients];
        for(int i=0;i<sizeClients;i++){
            if(i==0)
                costRoutes[i]=0;
            else
               costRoutes[i]= (Double)((double)(getVehicleList().get(veh).getDispatchNumber()*(double)getClientList().get(i).getPriority())*(distances[pivot][i])); 
        }
        int[] costIndexes = new int[sizeClients];
        int aux;
        double costAux;
        for(int i=0;i<sizeClients;i++){
            costIndexes[i]=i;
        }
        //se realiza un algoritmo de ordenacion simple
        //como el menor siempre será el costo al CD
        //elegimos al siguiente como el mejor
        for(int i=0;i<sizeClients;i++){
            for(int j=i;j<sizeClients;j++){
                if(costRoutes[i]>costRoutes[j]){
                    costAux = costRoutes[i];
                    costRoutes[i] =costRoutes[j];
                    costRoutes[j] = costAux;
                    aux = costIndexes[i];
                    costIndexes[i] = costIndexes[j];
                    costIndexes[j] = aux;
                }
            }
        }
        return costIndexes[position+1];
    } 
    
    public boolean verifyClientsServed(){
        int sizeClients = getClientList().size();
        for(int i=1;i<sizeClients;i++){//no se cuenta el CD
            if(getClientList().get(i).getRequestState()==0)//si el cliente no fue atendido, quiere decir que no todos fueron atendidos
                return false;//no todos fueron atendidos
        }
        return true; //todos fueron atendidos
    }
    
    public int searchBestNextClient(int pivot, int veh){
        //BUSCA EL MEJOR CLIENTE, A PARTIR DEL CLIENT PIVOTE (CLIENTE DE PARTIDA)
        int sizeClients = getClientList().size();
        int bestIndex=-1;
        boolean firstTime = true;
        for(int i=0;i<sizeClients;i++){
            if(i!=pivot && i!=0){//para que no se cuente asi mismo;
                if(getClientList().get(i).getRequestState()!=1){
                    if(firstTime==true){//elegimos el primer mejor posible para luego hacer las comparaciones
                        bestIndex = i;
                        firstTime = false;
                    }else{
                        double actualCost = 0;
                        double bestIndexCost = 0;
                        actualCost =((double)getVehicleList().get(veh).getDispatchNumber()*(double)getClientList().get(i).getPriority())*(distances[pivot][i]);
                        bestIndexCost =((double)getVehicleList().get(veh).getDispatchNumber()*(double)getClientList().get(bestIndex).getPriority())*(distances[pivot][bestIndex]);
                        if(actualCost<bestIndexCost){//si es mejor el costo (osea menor) lo elegimos
                            bestIndex = i;
                        }
                    }
                }
            }
        }
        return bestIndex;
    }
    
    public ArrayList<Integer> OptimizeTSearch(){        
        ArrayList<Integer> actualSolution = new ArrayList<Integer>();
        ArrayList<tabuElement> tabuList = new ArrayList<>(); 
        //Primero generar la solucion inicial
        initialSolution = generateInitialSolution();
        
        actualSolution = initialSolution;
        showRoute(actualSolution);
        //Realizar el bucle de parada:
        int index = 0;
        for(int i=0;i<stoppingCriterion;i++){
            ArrayList<solutionElement> possibleSolutions = new ArrayList<>();
            System.out.println("*** ITERACION "+i+" ****");
            double actualSolutionCost = calculateFunctionCost(actualSolution);//-->calcula funcion de costo de la solucion actual
            if(i>0){
                    updateTL(tabuList); //disminuyo en 1 la cantidad de iteraciones penalizadas
            }
            
            if(neighborpivot == 0)
                index = 0;
            if(index == neighborpivot)
                index = 0;
                ArrayList<neighborElement> neighbor = generateNeighbors(actualSolution,index);
                ArrayList<solutionElement> applicantGroup = optFindApplicants(actualSolutionCost,actualSolution,tabuList);//-->genera la lista de aspirantes
                ArrayList<solutionElement> reducedNeighbor = optGenerateReducedNeighbors(neighbor,tabuList,applicantGroup,actualSolution); 
                solutionElement bestNeighborSolution = optFindBestNeighbor(reducedNeighbor,actualSolution);
                possibleSolutions.add(bestNeighborSolution);
                index++;
            if(bestNeighborSolution!=null){      
                double bestNeighborCost = bestNeighborSolution.getCost();
                if(bestNeighborCost<=actualSolutionCost){ //significa que es MEJOR SOLUCION 
                   optAddNeighborToTL(bestNeighborSolution.getRoutes(),actualSolution,tabuList); //SE AÑADE A LA LISTA TABU
                   actualSolution = bestNeighborSolution.getRoutes(); //SE VUELVE LA SOLUCION ACTUAL
                   double cost = calculateFunctionCost(actualSolution);
                }else{ 
                        //A PESAR QUE NO ES LA MEJOR SOLUCION IGUAL SE PONDRA COMO SOLUCION ACTUAL.
                         actualSolution = bestNeighborSolution.getRoutes();
                         double cost = calculateFunctionCost(actualSolution);
                }
              }
        }
        //printSolution(actualSolution,1,time);
        return actualSolution;
    }
  
    public void copyActualSolutionToVehicules(ArrayList<Integer> solution){
        int size = solution.size();
        int vehIndex = -1;
        for(int i=0;i<size;i++){
            if(solution.get(i)==0 && i!=size-1){
                vehIndex++;
                getVehicleList().get(vehIndex).setRoute(new ArrayList<Integer>());
                getVehicleList().get(vehIndex).getRoute().add(0);
            }else{
                if(solution.get(i)!=0)
                getVehicleList().get(vehIndex).getRoute().add(solution.get(i));
            }
        }
    }
    
    public ArrayList<solutionElement> optFindApplicants(double actualSolutionCost,ArrayList<Integer> actualSolution,ArrayList<tabuElement> tabuList){
       /*FUNCION QUE SE ENCARGA DE BUSCAR ASPIRANTES
        SABIENDO QUE UN ASPIRANTES AQUELLAS SOLUCIONES TABU QUE PUEDEN SER
        MENORES QUE LA SOLUCION ACTUAL
        */
       int sizeTabuL = tabuList.size();     
       if(sizeTabuL!=0){
        ArrayList<solutionElement> applicants = new ArrayList<>();
        double tabuCost;
            for(int i=0;i<sizeTabuL;i++){
                ArrayList<Integer> tabuSol = tabuList.get(i).getTabuSolution();
                tabuCost = calculateFunctionCost(tabuSol);
                if(tabuCost<actualSolutionCost){
                   //CREAMOS LA SOLUCION EN UN ARREGLO
                   solutionElement sE = new solutionElement(tabuSol,tabuCost);
                   applicants.add(sE);
                }
            }
            return applicants;
       }else{
           return null;
       }
    }
    
    public ArrayList<solutionElement> optGenerateReducedNeighbors(ArrayList<neighborElement> neighbors,ArrayList<tabuElement> tabuList,ArrayList<solutionElement>applicants, ArrayList<Integer>actualSolution){
        int numberNeighbors = neighbors.size();
        int sizeTL = tabuList.size();
        int indexNewNeighbors = 0;
        int maxSize = getClientList().size()*2-1;
        ArrayList<Integer> neighborSolution=null;
        ArrayList<solutionElement> reducedNeighbor = new ArrayList<>();
        if(sizeTL!=0){
            for(int i=0;i<numberNeighbors;i++){//por cada elemento de la lista de vecinos
                boolean isTabuElement = false;
                for(int j=0;j<sizeTL;j++){//por cada elemento de la lista tabu
                    neighborSolution = createSolutionRoute(neighbors.get(i).getNeighbor(),actualSolution);
                    boolean isTabu = verifyTabuElement(neighborSolution,tabuList.get(j).getTabuSolution());
                    if(isTabu==true){
                        //si ese movimiento es el mismo movimiento tabu entonces no se agrega
                        isTabuElement =true;
                        break;                       
                    }
                }
                if(isTabuElement==false){
                    double cost = calculateFunctionCost(neighborSolution);
                    solutionElement sE = new solutionElement(neighborSolution,cost);
                    reducedNeighbor.add(sE);
                }
            }
        }else{
            for(int i=0;i<numberNeighbors;i++){//por cada elemento de la lista de vecinos
                ArrayList<Integer> neighborSol = createSolutionRoute(neighbors.get(i).getNeighbor(),actualSolution);
                double cost = calculateFunctionCost(neighborSol);
                solutionElement sE = new solutionElement(neighborSol,cost);
                reducedNeighbor.add(sE);         
            }
        }
        //se agrega los aspirantes (si es que hay)
        int sizeApplicants = 0;
        if(applicants!=null){
            sizeApplicants = applicants.size();
        }
        //se agrega los aspirantes
        for(int i=0;i<sizeApplicants;i++){            
              reducedNeighbor.add(applicants.get(i));
        }
        return reducedNeighbor;
    }
    
    private solutionElement optFindBestNeighbor(ArrayList<solutionElement> neighbor,ArrayList<Integer> solution){
        double bestCost = 0;
        solutionElement bestSol = null;
        int rowSizeN = neighbor.size();
        boolean firstTime = true;
        //Compara por cada vecino el mejor de ellos.
        for(int i=0;i<rowSizeN;i++){
            double cost = neighbor.get(i).getCost();
            if(firstTime == true){
                bestSol = new solutionElement(neighbor.get(i).getRoutes(),cost);
                firstTime = false;
            }else if(cost<bestSol.getCost()){
                 bestSol = new solutionElement(neighbor.get(i).getRoutes(),cost);
            }
        }
        return bestSol;
    } 
    
    public void optAddNeighborToTL(ArrayList<Integer> neighbor,ArrayList<Integer> actualSolution,ArrayList<tabuElement>tabuList){
       int sizeTL = tabuList.size();
       int olderIndex = -1;
       int olderNumbIteration = maxNumbIteration;
       if(sizeTL==maxSizeTL){ //esta lleno, buscar el mas antiguo
           for(int i=0;i<sizeTL;i++){
               if(tabuList.get(i).getIterationNumb()<olderNumbIteration){
                   olderIndex=i;
                   olderNumbIteration = tabuList.get(i).getIterationNumb();
               }
           }
           ArrayList<Integer> tabuSolution = neighbor;
           tabuElement newElement = new tabuElement(tabuSolution);
           tabuList.set(olderIndex, newElement);
       }
       else{
           ArrayList<Integer> tabuSolution = neighbor;
           tabuElement newElement = new tabuElement(tabuSolution);           
           tabuList.add(newElement);
       }
    }
    
    public ArrayList<neighborElement> generateNeighbors(ArrayList<Integer> solution, int pivot){
        //contar la cantidad de clientes participes
        //en todas las rutas.
        int sizeClients = countClientsInRoute(solution);     
        int sizeSolution = solution.size();
        int limit = 0;
        if(neighborpivot>0)
            limit = sizeSolution/neighborpivot;
        else
            limit = sizeSolution;
        ArrayList<neighborElement> neighbors = new ArrayList<>();
        int neighborIndex = 0;
        int init = pivot * limit;
        int end = (pivot+1)*limit;
        for(int i=init; i<end;i++){//por cada primer componente de la insercion (posicion pivote)
            for(int j=init;j<end;j++){
                if(i!=j && solution.get(i)!=0){ //si no es el mismo cliente y no es CD
                    if(solution.get(j)!=0){//si al que quiero mover no es CD
                        //Realizo el intercambio, es decir, añado los dos clientes en mi matriz neighbors
                        int[] auxiliar = new int[2];
                        auxiliar[0]=solution.get(i);
                        auxiliar[1]=solution.get(j);
                        ArrayList<Integer> newSol = createSolutionRoute(auxiliar,solution);
                        boolean isFeasible = isFeasibleSolution(newSol);
                        if(isFeasible==true && avoidButterflyProblem(newSol)==true){
                            int [] neighbor = new int[2];
                            neighbor[0] = solution.get(i);
                            neighbor[1] = solution.get(j);
                            neighborElement nE = new neighborElement(neighbor);
                            neighbors.add(nE);
                        }
                    }
                }
            }
        }
        return neighbors;
    }
    
    private boolean avoidButterflyProblem(ArrayList<Integer> solution){
        int size = solution.size();
        for(int i=1;i<size;i++){
            if(solution.get(i-1)!=0 && solution.get(i)!=0){
                int indexi = getClientIndex(solution.get(i));
                int indexi2 = getClientIndex(solution.get(i-1));
                double actualCost = distances[indexi2][indexi];
                double newCost = distances[0][indexi];
                if(actualCost>newCost)
                    return false;
            }
        }
        return true;
    }
    
    
    
    public boolean isFeasibleSolution(ArrayList<Integer> solution){
        int size = solution.size();
        boolean firstTime = true;
        double cost = 0;
        double capacity = getVehicleList().get(0).getCapacity();
        for(int i=0;i<size;i++){
            if(firstTime==true){
                firstTime =false;
            }else{
                if(solution.get(i)!=0){
                    Client c = queryByClienteId(solution.get(i));
                    cost+=c.getTotalWeight();
                }else{
                    if(cost>capacity)
                        return false;
                    else
                        cost = 0;
                }
            }
        }
        return true;
    }
    
    public int countClientsInRoute(ArrayList<Integer> solution){
        int count = 0;
        int size = solution.size();
        for(int i=0;i<size;i++){
            if (solution.get(i)!=0)
                count++;
        }
        return count;
    }
     
    public boolean verifyTabuElement(ArrayList<Integer> neighborSolution, ArrayList<Integer> tabuSolution){
        //funcion que verifica si un elemento vecino está en la lista tabú.
        int sizeN = neighborSolution.size();
        int sizeT = tabuSolution.size();
        if(sizeN==sizeT){
            for(int i=0;i<sizeN;i++){
                if(neighborSolution.get(i)!=tabuSolution.get(i))
                    return false;
            }
            return true;        
        }
        return false;
    }
      
    public double calculateFunctionCost(ArrayList<Integer> solution){
        int sizeArray = solution.size();//solucion con algunos datos en null;
        int sizeSolution = 0;
        for(int i=0;i<sizeArray;i++){
            if(solution.get(i)!=null)
                sizeSolution++;
            else
                break;
        }
        double cost = 0;
        double freeCapacity = 0;
        int indexVec = -1;
        boolean firstVec = true;
        //considerar routesCost como la distancia.
        double factor1 = 0;
        double factor2 = 0;
        Vehicle v = null;
        for(int i=0;i<sizeSolution-1;i++){
           //si es primer vehiculo 
            if(solution.get(i)==0){//primer vehiculo
                indexVec++;
                v = getVehicleList().get(indexVec);
                freeCapacity=v.getCapacity();
                int indexInit = getClientIndex(solution.get(i));
                int indexEnd = getClientIndex(solution.get(i+1));
                factor1 = (v.getDispatchNumber()*1.0)*(getClientList().get(indexEnd).getPriority()*1.0);
                factor2 = 1.0;
                cost+=(Double)((factor1)*distances[indexInit][indexEnd]*(factor2));
            }else {
                int indexInit = getClientIndex(solution.get(i));
                int indexEnd = getClientIndex(solution.get(i+1));
                if(getClientList().get(indexEnd).getIdClient()!=0){//si no es el regreso
                    //EN BASE A LOS DESPACHO SE CALCULA EL PESO TOTAL
                    //SE CREA EN LA BASE CUANDO SE EJECUTA LA SIMULACION LEYENDO LOS DESPACHOS
                    //freeCapacity-=clientList.get(indexInit).getTotalWeight();
                    factor1 = (v.getDispatchNumber()*1.0)*(getClientList().get(indexEnd).getPriority()*1.0);
                }else{
                    factor1 = (v.getDispatchNumber()*1.0)/(1.0);
                }
                factor2 = (double)1.0;
                cost+=(Double)((factor1)*distances[indexInit][indexEnd]*(factor2));
            }
        }
        return Math.round(cost*100)/100;
    }
   
    public int getClientIndex(int id){
        int sizeClient = getClientList().size();
        for(int i=0;i<sizeClient;i++){
            if(getClientList().get(i).getIdClient()==id)
                return i;
        }
        return -1;
    }
   
    public ArrayList<Integer> createSolutionRoute(int[] solutionMove, ArrayList<Integer> solution){
        int index1=-1;
        int index2=-1;
        int sizeSolution = solution.size();
        ArrayList<Integer> solutionArray = new ArrayList<>();
        for(int i=0;i<sizeSolution;i++){
            solutionArray.add(solution.get(i));
        }
        for(int i=0;i<sizeSolution;i++){
            if(solutionArray.get(i)==solutionMove[0])
                index1 = i;
            else if(solutionArray.get(i)==solutionMove[1])
                index2 = i;
            if(index1!=-1 && index2!=-1)
                break;
        }
        //procedimiento de INTERCAMBIO de index1 a index2
        int client = solutionArray.get(index1);
        //FORMA 2: INTERCAMBIO
        solutionArray.set(index1,solution.get(index2));
        solutionArray.set(index2, client);
        return solutionArray;
    }
        
    public void addNeighborToTL(ArrayList<Integer> neighbor,ArrayList<Integer> actualSolution,ArrayList<tabuElement>tabuList){
       int sizeTL = tabuList.size();
       int olderIndex = -1;
       int olderNumbIteration = maxNumbIteration;
       if(sizeTL==maxSizeTL){ //esta lleno, buscar el mas antiguo
           for(int i=0;i<sizeTL;i++){
               if(tabuList.get(i).getIterationNumb()<olderNumbIteration){
                   olderIndex=i;
                   olderNumbIteration = tabuList.get(i).getIterationNumb();
               }
           }
           ArrayList<Integer> tabuSolution = neighbor;
           tabuElement newElement = new tabuElement(tabuSolution);
           tabuList.set(olderIndex, newElement);
       }
       else{
           ArrayList<Integer> tabuSolution = neighbor;
           tabuElement newElement = new tabuElement(tabuSolution);           
           tabuList.add(newElement);
       }
              
    }
    
    public void updateClients(ArrayList<Integer> solution){
        /*FUNCION QUE ACTUALIZA LOS ESTADOS DE LOS CLIENTES EN ATENDIDO.*/
        int sizeSol = solution.size();
        int count = 0;
        ArrayList<Client> clientListAux = new ArrayList<>();
        for(int i=0;i<sizeSol;i++){
            int index = getClientIndex(solution.get(i));            
            if(getClientList().get(index).getIdClient()!=0){
                getClientList().get(index).setRequestState(1);
                count++;
            }
        }
        int sizeClients = getClientList().size();
        for(int i=0;i<sizeClients;i++){
            if(getClientList().get(i).getRequestState()==0)
                clientListAux.add(getClientList().get(i));
        }
        setClientList(clientListAux);
        System.out.println("TOTAL "+count);
    }
    
    public void updateTL( ArrayList<tabuElement> tabuList){
       //FUNCION QUE SE ENCARGA DE ELIMINAR A LOS ELEMENTOS QUE YA CUMPLIERON CON SU PENALIZACION
       //EN CASO QUE AUN NO, SOLO SE LE DESCUENTA UNA ITERACION
       int size = tabuList.size();
       int[] indexesToDelete = new int[size];
       int indexesCount = 0;
        for(int i=0;i<size;i++){
            int numbIteration = tabuList.get(i).getIterationNumb();
            tabuList.get(i).setIterationNumb(numbIteration-1);
           if(numbIteration-1==0){ //retirar de la lista tabu
               indexesToDelete[indexesCount] = i;
               indexesCount++;
           }
        } 
        ArrayList<tabuElement> newTabuList = new ArrayList<>();
        for(int i=0;i<size;i++){
            boolean leaveTabuList = false;
            for(int j=0;j<indexesCount;j++){
                if(i==indexesToDelete[j]){
                    leaveTabuList = true;
                    break;
                }
            }
            if(leaveTabuList == false){
                newTabuList.add(tabuList.get(i));
            }
        }
        tabuList = newTabuList;
        
    }
    
    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public void setVehiculeList(List<Vehicle> vehiculeList) {
        this.setVehicleList(getVehicleList());
    }

    public Client queryByClienteId(int id){
        /*FUNCION QUE BUSCA EL CLIENTE POR ID**/
        int size = getClientList().size();
        for(int i=0;i<size;i++){
            if(getClientList().get(i).getIdClient()==id){
                return getClientList().get(i);
            }
        }
        return null;
    }

    public List<Client> getClientList() {
        return clientList;
    }

    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }
    
    public void showRoute(ArrayList<Integer> solution){  
        /*FUNCION QUE RETORNA LA RUTA IMPRESA*/
        int size = solution.size();
        int vecSize = 0;
        for(int i=0;i<size;i++){
            if(i==0){
                System.out.print("VEHICULO "+(vecSize)+": ");
                vecSize++;
            }
            else if(solution.get(i)==0 && i!=0){
                //p.println(solution.get(i));
                System.out.println(solution.get(i));  
                System.out.print("VEHICULO "+(vecSize)+": ");
                vecSize++;
            }else
                //p.println(solution.get(i)+"-");
                System.out.print(solution.get(i)+"-");            
        }
    }
    
    public void showNoAttendedClients(){        
        /*FUNCION QUE MUESTRA QUE CLIENTES NO FUERON ATENDIDOS*/
        int sizeClient = getClientList().size();
        for(int i=0;i<sizeClient;i++){
            if(getClientList().get(i).getRequestState()==0){
                //p.println("CLIENTE "+clientList.get(i).getName()+" NO ATENDIDO");
                System.out.println("CLIENTE "+getClientList().get(i).getName()+" NO ATENDIDO");                
            }
        }
    }
    
    public void printSolution(ArrayList<Integer> solution,int type,int time) throws IOException{
        
        int size = solution.size();
        String fileS = null;
        if(type ==0)
         fileS = new String("F:\\PUCP\\2015-1\\DP1\\VERSIONES TABU SEARCH\\TABU SEARCH ALGORITHM V3.0\\log\\Solucion_Inicial"+time+".txt");
        else
           fileS = new String("F:\\PUCP\\2015-1\\DP1\\VERSIONES TABU SEARCH\\TABU SEARCH ALGORITHM V3.0\\log\\solucion_Tabu"+time+".txt");
        if(fileS !=null){
            BufferedWriter solutionFile = new BufferedWriter(new FileWriter(fileS));
            boolean firstTime = true;
            solutionFile.write("VIAJE "+time);
            
            int index = 1;
            for(int i=0;i<size;i++){
                   if(i==0){
                       solutionFile.newLine();
                       solutionFile.write("VEHICULO: "+index+": 0-");
                       index++;
                   }
                   else if(solution.get(i)==0&&i!=size-1){
                       
                       solutionFile.write("0");
                       solutionFile.newLine();
                       solutionFile.write("VEHICULO: "+index+": 0-");
                       index++;
                    }
                   else if(i==size-1)
                           solutionFile.write("0");
                   else{
                       solutionFile.write(solution.get(i).toString()+"-");
                       
                   }
                
                
            }
            solutionFile.close();
        }
    }
    
    public ArrayList<String> generateRoutes(ArrayList<Integer> solution){
        ArrayList<String> sol = new ArrayList<>();
        int size = solution.size();
        String route = null;
        for(int i=0;i<size;i++){
            if(i==0){
                route = new String();
                route = "0-";
            }else if(solution.get(i)==0&&i!=size-1){
                route+="0";
                sol.add(route);
                route= new String();
                route = "0-";
            }else if(i==size-1){
                route+="0";
                sol.add(route);
            }else{
                route+=solution.get(i)+"-";
            }
        }
        return sol;
    }
}

