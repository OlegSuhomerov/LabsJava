package by.gsu.pms;



public class Runner {

    public static void main(String[] args) {
        BusinessTrip[] businessTrips = {
                new BusinessTrip("Ivan Ivanov",45600, 4),
                new BusinessTrip("Sergei Sergeev",12000,1),
                null,
                new BusinessTrip("Oleg Olegov",67700,6),
                new BusinessTrip("Dima Dimov",77700,7),
                new BusinessTrip("Anton Taranov",98900,17),
                new BusinessTrip()
        };


        for (BusinessTrip trip : businessTrips) {
            if (trip != null) {
                trip.show();
            }
            System.out.println("\n");
        }

        businessTrips[businessTrips.length-1].setPriceTransport(6000);

        System.out.println("Duration = " + (businessTrips[0].getNumberDays() + businessTrips[1].getNumberDays()) );
        System.out.println("\n");

        for (BusinessTrip trip : businessTrips){
            System.out.println(trip);
        }

       

    }

}


