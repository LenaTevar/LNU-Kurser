using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Loggboken_v2
{
    public partial class nyBokForm : Form
    {
        public nyBokForm()
        {
            InitializeComponent();
            /*Lita inte på människorna. Det hjälper att 
            användaren inte kan addera ett bok utan att
            kolla ISBN:n först.
            */
            btn_NewBokAdd.Enabled = false;
            
        }

        private void btn_NewBok01_Click(object sender, EventArgs e)
        {
            toErase_01.Text = txtbIsbn.Text;
             
            try
            {
                int isbn = int.Parse(txtbIsbn.Text);
               


                //Int32.TryParse(Console.ReadLine(), out isbn); 
                //Förbättra det här. Vad om isbn finns redan? (23/01)                            
                //nyBok.ISBN = isbn;
                //lita inte på människor
                btn_NewBokAdd.Enabled = true;
            }
            catch
            {
                toErase_01.Text = "Oops!";
              
            }


        }

        private void btn_NewBokClose_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void btn_NewBokAdd_Click(object sender, EventArgs e)
        {
            
        }
    }
}
