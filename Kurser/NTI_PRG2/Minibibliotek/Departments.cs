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
    public partial class DepartmentsForm : Form
    {
        public DepartmentsForm()
        {
            InitializeComponent();
        }

        private void departmentsBindingNavigatorSaveItem_Click(object sender, EventArgs e)
        {
            this.Validate();
            this.departmentsBindingSource.EndEdit();
            this.tableAdapterManager.UpdateAll(this.booksDBDataSet);

        }

        private void DepartmentsForm_Load(object sender, EventArgs e)
        {
            // TODO: This line of code loads data into the 'booksDBDataSet.departments' table. You can move, or remove it, as needed.
            this.departmentsTableAdapter.Fill(this.booksDBDataSet.departments);

        }
    }
}
