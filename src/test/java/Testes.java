import Exceptions.UserAlreadyExists;
import Exceptions.UserDoesNotExists;
import Models.User;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Testes {

    BikeRentalSystem bikeRentalSystem;
    BikeRentalSystem bikeRentalSystemTestVerifyCredit;


    @BeforeAll
    public static void initAll(){

        System.out.println("Unit Tests:");

    }

    @BeforeEach
    public void setUp() throws UserAlreadyExists{

   /* bikes = new BikeRentalSystem(1);*/
        bikeRentalSystem = new BikeRentalSystem(10);

//    bikes.registerUser(2,"Olga",1);
//    bikes.addLock(0,0);
//    bikes.addBicycle(0,0,0);


    }

    @Test
    public void testRegisterUser() throws UserAlreadyExists {

        assertAll(() ->
                {
                    // Limite da variável IDUser
                    this.bikeRentalSystem.registerUser(0, "Olga", 1);

                }
        );

        assertAll(() ->
                {

                    // Limite +1 da variável IDUser
                    this.bikeRentalSystem.registerUser(1, "Jose", 2);

                }
        );
        assertAll(() ->
                {

                    // Limite -1 da variável IDUser
                    this.bikeRentalSystem.registerUser(-1, "Carlos", 2);

                }
        );
        assertAll(() ->
                {

                    // Limite inferior da variável rentalProgram
                    this.bikeRentalSystem.registerUser(2, "Firmino", 1);

                }
        );

        assertAll(() ->
                {
                    // Limite superior da variável rentalProgram
                    this.bikeRentalSystem.registerUser(4, "Patricia", 2);

                }
        );


        assertAll(() ->
                {

                    // Limite inferior-1 da variável rentalProgram
                    this.bikeRentalSystem.registerUser(3, "Ana", 0);

                }
        );


        assertAll(() ->
                {

                    //  Limite superior+1 da variável rentalProgram
                    this.bikeRentalSystem.registerUser(1, "Pedro", 3);
                }
        );

    }

        /*assertThrows(UserAlreadyExists.class,()->{

           bikes.registerUser(2,"Olga",1);

        },"Should Throw Exception: UserAlreadyExists");
*/





    @AfterEach


    @BeforeEach
    public void setUpTestVerifyCredit() throws UserAlreadyExists{

        this.bikeRentalSystemTestVerifyCredit = new BikeRentalSystem(10);

    }

    @Test
    public void testVerifyCredit() throws UserAlreadyExists {

        this.bikeRentalSystemTestVerifyCredit.registerUser(1,"Jose",1);
        this.bikeRentalSystemTestVerifyCredit.registerUser(2,"Olga",1);
        this.bikeRentalSystemTestVerifyCredit.registerUser(3,"Olga",1);

        //Adiciona um credito ao utilizador de ID = 2
        this.bikeRentalSystemTestVerifyCredit.addCredit(2,11);
        this.bikeRentalSystemTestVerifyCredit.addCredit(3,-10);

        assertTrue(this.bikeRentalSystemTestVerifyCredit.verifyCredit(2));
        assertTrue(this.bikeRentalSystemTestVerifyCredit.verifyCredit(3));
//        assertTrue(bikes.verifyCredit(4));




    }


    @Test
    public void testAddCredit()throws UserAlreadyExists{

        this.bikeRentalSystem.registerUser(1,"Jose",1);

        this.bikeRentalSystem.addCredit(0,2);

        assertEquals(0, this.bikeRentalSystem.getUsers().get(0).getCredit(),
                "!!!");


    }


    @AfterEach


    @BeforeEach
    public void SetUpBicycleRentalFeeTest() throws NullPointerException{

        this.bikeRentalSystemTestVerifyCredit= new BikeRentalSystem(10);


    }
    @Test
    public void bicycleRentalFeeTest() throws NullPointerException{


        //this.bikeRentalSystemTestVerifyCredit.bicycleRentalFee(1,2,55,3);
        //this.bikeRentalSystemTestVerifyCredit.bicycleRentalFee(1,2,55,3);


        assertEquals(10,this.bikeRentalSystem.bicycleRentalFee(2,-1,0,1));
    }

    @BeforeEach
    public void SetUpReturnBicycleTest() throws NullPointerException{
        this.bikeRentalSystemTestVerifyCredit= new BikeRentalSystem(10);



           }

    @Test
    public void returnBicycleTest()throws NullPointerException{

        assertEquals(-1,this.bikeRentalSystem.returnBicycle(-2,0,-1));
    }
    //@AfterAll

    }




