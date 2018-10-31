using System;
using System.Collections;
using System.Collections.Generic;
using System.Windows.Forms;

namespace Loggboken_v2
{
    public partial class Form1 : Form
    {

        public Form1()
        {
            InitializeComponent();
        }
        
     

        //Window
        private void cascadeToolStripMenuItem_Click(object sender, EventArgs e)
        {
            this.LayoutMdi(MdiLayout.Cascade);
        }

        private void tileHorizontalToolStripMenuItem_Click(object sender, EventArgs e)
        {
            this.LayoutMdi(MdiLayout.TileHorizontal);
        }

        private void tileVerticalToolStripMenuItem_Click(object sender, EventArgs e)
        {
            this.LayoutMdi(MdiLayout.TileVertical);
        }
        //Window END

        //NEW BOK
        private void addBookToolStripMenuItem1_Click(object sender, EventArgs e)
        {
            nyBokForm nyBok = new nyBokForm();
            nyBok.MdiParent = this;
            nyBok.Show();
        }

        //CLOSE >>SAKNAS "SAVE"<<
        private void exportAndCloseToolStripMenuItem_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void findBookToolStripMenuItem_Click(object sender, EventArgs e)
        {
            FindBok hitta = new FindBok();
            hitta.MdiParent = this;
            hitta.Show();
        }
    }
}
