using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;

namespace loggBoken
{
    class Bok
    {
        public string Title { get; set; }
        public string Author { get; set; }
        public DateTime Date = DateTime.Now; 
        public int ISBN { get; set; }
        public string Text { get; set; }
        //public int antalBok { get; set; } //Om addera nybok-> isbn finns, antalbok++.... men det behövs inte
    }


    class Program
    {
        private static void skrivUt(Bok bok) 
        {
            //Helper Method för att skriva ut en bok. (26/01)
            //Vi kommer att skriva ut böckerna flera gånger. 
            Console.WriteLine("\n\t {0} -- {1} -- {2} -- {3} -- {4}",                                   
                bok.ISBN,                                    
                bok.Title,                                    
                bok.Author,                                    
                bok.Date,                                    
                bok.Text);
        }

       
               
        static void Main(string[] args)
        {
            bool start = true;
            Dictionary<int, Bok> loggBok = new Dictionary<int, Bok>();
            StreamWriter fil = new StreamWriter("books.txt"); // docs/visualstudio/loggboken/bin/debug
            while (start)
            {
               
                Console.WriteLine("\n\t-------------------------------");
                Console.WriteLine("\n\t| Välkommen till din loggBok. |");
                Console.WriteLine("\n\t-------------------------------");
                Console.WriteLine("\n\t[1]Addera en ny bok.");
                Console.WriteLine("\n\t[2]Hitta en bok.");
                Console.WriteLine("\n\t[3]Skriv ut loggen."); 
                Console.WriteLine("\n\t[4]Redigera eller suda loggen."); //+ta bort >>EN< bok >>DONE (23/01)<<
                Console.WriteLine("\n\t[5]Spara och Avsluta programmet."); //+streamreader >>DONE (26/01)
                //Jag har ingen åning  hur öppna streamreader fil efter fil.Close(); 
                //så jag ska fuska lite med "spara och avsluta" så det crashar inte ;) (26/01)
                //Om nånting är dumbt men funkar,  är det inte dumbt. 
                int val;
                Int32.TryParse(Console.ReadLine(), out val);//Undantagshantering (22/01)

                switch (val)  
                {

                    case 1: //Addera en ny bok
                        Bok nyBok = new Bok();
                       
                        
                        Console.WriteLine("\n\tSkriv ISBN:");
                        try
                        {
                            int isbn = int.Parse(Console.ReadLine());
                            //Int32.TryParse(Console.ReadLine(), out isbn); 
                            //Förbättra det här. Vad om isbn finns redan? (23/01)                            
                            nyBok.ISBN = isbn;
                            //lita inte på människor
                        }
                        catch
                        {
                            Console.WriteLine("\n\tFelaktig ISBN.");
                            goto case 1; //loop för att repetera ISBN
                        }
                        
                        if (loggBok.ContainsKey(nyBok.ISBN)) //mer Undantagshantering! (26/01)
                        {
                            Console.WriteLine("\n\tDet finns en bok redan registrerad med det här ISBN.");
                            skrivUt(loggBok[nyBok.ISBN]); //Helper method
                            break;
                        }
                            
                        else
                        {
                            Console.WriteLine("\n\tSkriv titlen:");
                            nyBok.Title = Console.ReadLine();
                            Console.WriteLine("\n\tSkriv författare:");
                            nyBok.Author = Console.ReadLine();
                            Console.WriteLine("\n\tSkriv meddelande:");
                            nyBok.Text = Console.ReadLine();

                            loggBok.Add(nyBok.ISBN, nyBok);

                            //fil.WriteLine(" AUTHOR: {0}", nyBok.Author); 
                            //fil.WriteLine(" TITLE: {0}", nyBok.Title);
                            //fil.WriteLine(" DATE: {0}", nyBok.Date);
                            //fil.WriteLine("ISBN: {0}", loggBok[nyBok.ISBN].ISBN);
                            //fil.WriteLine("_____________");
                            //fil.Close();
                            //An unhandled exception of type 'System.ObjectDisposedException' occurred in mscorlib.dll t(-_-t) (26/01)

                            Console.WriteLine("\n\tTack!");
                            break;
                        }
                        

                    case 2://HITTA 
                        Console.WriteLine("\n\tSkriv ISBN att hitta:");
                        int search;
                        Int32.TryParse(Console.ReadLine(), out search);
                        if (loggBok.ContainsKey(search)== true)
                        {
                            //DateTime datebok = loggBok[search].Date; //onyttigt (21/01)
                            Console.WriteLine("\n\t{0} var registrerad i loggboken dagen {1}.", 
                                loggBok[search].Title, 
                                loggBok[search].Date);
                        }
                        else
                        {
                            Console.WriteLine("\n\tDet finns ingen bok med det isbn.");
                        }
                        break;

                    case 3://SKRIV UT
                        Console.WriteLine("\n\t\t\t\t--------");
                        Console.WriteLine("\n\t| TITLE \tFÖRFATTARE\tREGISTRERAD\tMEDDELANDE|");
                        Console.WriteLine("\n\t\t\t\t--------"); ;

                        var list = loggBok.Keys.ToList(); //sorterad (28/01)
                        list.Sort();
                        foreach (var key in list)
                        {
                            skrivUt(loggBok[key]);
                        }

                        //foreach (var item in loggBok.Values) //Framtiden Lena, sortera det här.
                        //{
                        //    skrivUt(item);

                        //    //Console.WriteLine("\n\t {0} -- {1} -- {2} -- {3}", //HELPER METHOD ftw (26/01)
                        //    //    item.Title, 
                        //    //    item.Author, 
                        //    //    item.Date,
                        //    //    item.Text);
                        //}
                        Console.WriteLine("\n\t\t\t\t--------"); ;
                        break;

                    case 4://SUDA
                        int val2;
                        Console.WriteLine("\n\t[1] Ta bort EN bok.");
                        Console.WriteLine("\n\t[2] Suda hela listan.");
                        Console.WriteLine("\n\t[3] Redigera en bok.");
                        
                        Int32.TryParse(Console.ReadLine(), out val2);
                        switch(val2)
                        {
                            
                            case 1: //EN BOK
                                Console.WriteLine("\n\tTa bort en bok. Skriv ISBN:");
                                int suda;
                                Int32.TryParse(Console.ReadLine(), out suda);
                                
                                try
                                {
                                    fil.Write("\n\tRADERAD: {0} - {1} - {2}", 
                                        loggBok[suda].ISBN, 
                                        loggBok[suda].Title, 
                                        loggBok[suda].Title); 
                                        //Värför funkar det inte!!! >.> (23/01) loggBok(suda) != loggBok[suda] dummy (26/01)
                                    Console.WriteLine("\n\tBoken raderad");
                                    loggBok.Remove(suda);
                                    
                                }
                                catch
                                {
                                    Console.WriteLine("\n\tDet finns ingen bok med det ISBN");
                                }
                                break;
                               
                            case 2: //HELA LISTAN
                                loggBok.Clear();
                                Console.WriteLine("\n\tLoggboken är tomt.");
                                break;                            
                            
                            case 3://REDIGERA
                                Console.WriteLine("\n\tSkriv ISBN att redigera:");
                                int search2;
                                Int32.TryParse(Console.ReadLine(), out search2);
                                if (loggBok.ContainsKey(search2) == true) //mer Undantagshantering!!!!
                                {
                                    skrivUt(loggBok[search2]);                                                                                                      
                                    bool redibool = true;
                                    while (redibool)
                                    {
                                        try
                                        {
                                            Console.WriteLine("\n\tSkriv ny ISBN:");
                                            //imorgon addera mer undantagshantering. Vad om ny isbn finns redan i listan??? (26/01) GJORT (28/01)
                                            int rediIsbn;
                                            Int32.TryParse(Console.ReadLine(), out rediIsbn);

                                            if (loggBok.ContainsKey(rediIsbn)==true)
                                            {
                                                Console.WriteLine("\n\tISBN upptagen.");
                                                
                                            }
                                            else
                                            {   //swicht???1: redi isbn, 2: redi title, 3: redi author osv??? (26/01)
                                                
                                                loggBok[search2].ISBN = rediIsbn;
                                                Console.WriteLine("\n\tSkriv ny titlen:"); 
                                                loggBok[search2].Title = Console.ReadLine();
                                                Console.WriteLine("\n\tSkriv ny författare:");
                                                loggBok[search2].Author = Console.ReadLine();
                                                Console.WriteLine("\n\tSkriv ny meddelande:");
                                                loggBok[search2].Text = Console.ReadLine();
                                                
                                                redibool = false;
                                                break;
                                            }                                   
                                            
                                        }
                                        catch
                                        {
                                            Console.WriteLine("\n\tFelaktig ISBN.");
                                            break;
                                        }
                                    }//while redibool
                                    break;                                    
                                }

                                else //från "if det finns boken i listan" 
                                {
                                    Console.WriteLine("Det finns ingen bok med det här ISBN.");
                                    break;
                                }



                            default:
                                break;
                        }
                        break;                    
                        
                    case 5: //avsluta
                        start = false;
                        var list2 = loggBok.Keys.ToList(); //sorterad (28/01)
                        list2.Sort();
                        foreach (var key in list2)
                        {
                            fil.Write("ISB: {0} - FÖRFATTARE: {1} - TITLEN: {2} - REGISTRERAD: {3} - MEDDELANDE:{4}",
                                list2,
                                loggBok[key].Author,
                                loggBok[key].Title,
                                loggBok[key].Date,
                                loggBok[key].Text);
                        }



                        //foreach (int isbnKey in loggBok.Keys)
                        //{
                        //    fil.Write("ISB: {0} - FÖRFATTARE: {1} - TITLEN: {2} - REGISTRERAD: {3} - MEDDELANDE:{4}", 
                        //        isbnKey, 
                        //        loggBok[list].Author, 
                        //        loggBok[list].Title, 
                        //        loggBok[list].Date, 
                        //        loggBok[list].Text);
                        //}
                        fil.Close();
                        Console.WriteLine("\n\tLoggboken har exporterat till books.txt\n\tTrycka för att avsluta programmet. ");
                        Console.ReadLine();
                        break;
                    default:
                        break;
                }
            }
        }//main
    }//program    
}
