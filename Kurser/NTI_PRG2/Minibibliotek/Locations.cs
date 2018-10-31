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
    public partial class LocationsForm : Form
    {
        public LocationsForm()
        {
            InitializeComponent();
        }

        private void locationsBindingNavigatorSaveItem_Click(object sender, EventArgs e)
        {
            this.Validate();
            this.locationsBindingSource.EndEdit();
            this.tableAdapterManager.UpdateAll(this.booksDBDataSet);

        }

        private void LocationsForm_Load(object sender, EventArgs e)
        {
            // TODO: This line of code loads data into the 'booksDBDataSet.Locations' table. You can move, or remove it, as needed.
            this.locationsTableAdapter.Fill(this.booksDBDataSet.Locations);

        }
    }
}
