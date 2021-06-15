package models;

public enum AnimalProductTypes {
        EGG(1 , 4 , 15),
        FEATHER(1 , 4 , 20),
        MILK(1,4, 25);

        private final int depotSize;
        private final int saleCost;
        private final int inMapRunTime;


        AnimalProductTypes(int depotSize, int inMapRunTime, int saleCost) {
            this.depotSize = depotSize;
            this.saleCost = saleCost;
            this.inMapRunTime = inMapRunTime;

        }

        public int getDepotSize() {
            return depotSize;
        }

        public int getInMapRunTime() { return inMapRunTime; }

        public int getSaleCost() {
            return saleCost;
        }

}
