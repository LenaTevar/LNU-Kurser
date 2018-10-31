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
    public partial class SearchForm : Form
    {
        public SearchForm()
        {
            InitializeComponent();
        }

        private void booksBindingNavigatorSaveItem_Click(object sender, EventArgs e)
        {
            this.Validate();
            this.booksBindingSource.EndEdit();
            this.tableAdapterManager.UpdateAll(this.booksDBDataSet);

        }

        private void SearchForm_Load(object sender, EventArgs e)
        {
            // TODO: This line of code loads data into the 'booksDBDataSet.Books' table. You can move, or remove it, as needed.
            this.booksTableAdapter.Fill(this.booksDBDataSet.Books);

        }
        //Search method
        private void button1_Click(object sender, EventArgs e)
        {
            booksTableAdapter.FillByTitle(
                booksDBDataSet.Books, textBox1.Text);
        }

        //Clean method
        private void button2_Click(object sender, EventArgs e)
        {
            booksTableAdapter.Fill(
                booksDBDataSet.Books);
            textBox1.Text = " ";
        }
    }
}

