using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Minibibliotek
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
           
        }

        private void closeToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        
        /*Ni kan inte se så många komentärer i projektet på grund av 
         jag har gjort om igen och igen projektet till jag blev galem.

        I början villa jag bara ett program för att spara böcker, då 
        ville jag ett bibliotek men det var för mycket.. nu är det
        nånting mellan dessa två tänkar.
       
        Jag har noll konst-känslor så.. yep, förlåt om det är fullt. 
        I Webbprogrammering 1 upptäckte jag att jag är inte en 
        front-end person.          
         */

        //LAYOUT
        private void cascadeToolStripMenuItem_Click(object sender, EventArgs e)
        {
            this.LayoutMdi(MdiLayout.Cascade);
        }

        private void horizontalToolStripMenuItem_Click(object sender, EventArgs e)
        {
            this.LayoutMdi(MdiLayout.TileHorizontal);
        }

        private void verticalToolStripMenuItem_Click(object sender, EventArgs e)
        {
            this.LayoutMdi(MdiLayout.TileVertical);
        }
        //END LAYOUT

        //MDI BARN SHOW
        private void booksToolStripMenuItem_Click(object sender, EventArgs e)
        {
            BooksForm newBook = new BooksForm();
            newBook.MdiParent = this;
            newBook.Show();
        }

        private void departmentsToolStripMenuItem_Click(object sender, EventArgs e)
        {
            DepartmentsForm newDepartment = new DepartmentsForm();
            newDepartment.MdiParent = this;
            newDepartment.Show();
        }

        private void locationsToolStripMenuItem_Click(object sender, EventArgs e)
        {
            LocationsForm newLocation = new LocationsForm();
            newLocation.MdiParent = this;
            newLocation.Show();
        }

        private void searchToolStripMenuItem_Click(object sender, EventArgs e)
        {
            SearchForm newSearch = new SearchForm();
            newSearch.MdiParent = this;
            newSearch.Show();
        }

        //END MDI BARN SHOW
    }
}
