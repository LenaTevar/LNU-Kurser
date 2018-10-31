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
    public partial class FindBok : Form
    {
        public FindBok()
        {
            InitializeComponent();
        }

        private void btnFBClose_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
