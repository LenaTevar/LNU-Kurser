namespace Minibibliotek
{
    partial class DepartmentsForm
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            System.Windows.Forms.Label departmentIDLabel;
            System.Windows.Forms.Label nameLabel;
            System.Windows.Forms.Label managerLabel;
            System.Windows.Forms.Label locationIDLabel;
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(DepartmentsForm));
            this.booksDBDataSet = new Minibibliotek.BooksDBDataSet();
            this.departmentsBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.departmentsTableAdapter = new Minibibliotek.BooksDBDataSetTableAdapters.departmentsTableAdapter();
            this.tableAdapterManager = new Minibibliotek.BooksDBDataSetTableAdapters.TableAdapterManager();
            this.departmentsBindingNavigator = new System.Windows.Forms.BindingNavigator(this.components);
            this.bindingNavigatorAddNewItem = new System.Windows.Forms.ToolStripButton();
            this.bindingNavigatorCountItem = new System.Windows.Forms.ToolStripLabel();
            this.bindingNavigatorDeleteItem = new System.Windows.Forms.ToolStripButton();
            this.bindingNavigatorMoveFirstItem = new System.Windows.Forms.ToolStripButton();
            this.bindingNavigatorMovePreviousItem = new System.Windows.Forms.ToolStripButton();
            this.bindingNavigatorSeparator = new System.Windows.Forms.ToolStripSeparator();
            this.bindingNavigatorPositionItem = new System.Windows.Forms.ToolStripTextBox();
            this.bindingNavigatorSeparator1 = new System.Windows.Forms.ToolStripSeparator();
            this.bindingNavigatorMoveNextItem = new System.Windows.Forms.ToolStripButton();
            this.bindingNavigatorMoveLastItem = new System.Windows.Forms.ToolStripButton();
            this.bindingNavigatorSeparator2 = new System.Windows.Forms.ToolStripSeparator();
            this.departmentsBindingNavigatorSaveItem = new System.Windows.Forms.ToolStripButton();
            this.departmentIDTextBox = new System.Windows.Forms.TextBox();
            this.nameTextBox = new System.Windows.Forms.TextBox();
            this.managerTextBox = new System.Windows.Forms.TextBox();
            this.locationIDTextBox = new System.Windows.Forms.TextBox();
            departmentIDLabel = new System.Windows.Forms.Label();
            nameLabel = new System.Windows.Forms.Label();
            managerLabel = new System.Windows.Forms.Label();
            locationIDLabel = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize)(this.booksDBDataSet)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.departmentsBindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.departmentsBindingNavigator)).BeginInit();
            this.departmentsBindingNavigator.SuspendLayout();
            this.SuspendLayout();
            // 
            // departmentIDLabel
            // 
            departmentIDLabel.AutoSize = true;
            departmentIDLabel.BackColor = System.Drawing.Color.Transparent;
            departmentIDLabel.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            departmentIDLabel.Location = new System.Drawing.Point(12, 40);
            departmentIDLabel.Name = "departmentIDLabel";
            departmentIDLabel.Size = new System.Drawing.Size(103, 17);
            departmentIDLabel.TabIndex = 1;
            departmentIDLabel.Text = "Department ID:";
            // 
            // nameLabel
            // 
            nameLabel.AutoSize = true;
            nameLabel.BackColor = System.Drawing.Color.Transparent;
            nameLabel.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            nameLabel.Location = new System.Drawing.Point(12, 66);
            nameLabel.Name = "nameLabel";
            nameLabel.Size = new System.Drawing.Size(49, 17);
            nameLabel.TabIndex = 3;
            nameLabel.Text = "Name:";
            // 
            // managerLabel
            // 
            managerLabel.AutoSize = true;
            managerLabel.BackColor = System.Drawing.Color.Transparent;
            managerLabel.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            managerLabel.Location = new System.Drawing.Point(12, 92);
            managerLabel.Name = "managerLabel";
            managerLabel.Size = new System.Drawing.Size(68, 17);
            managerLabel.TabIndex = 5;
            managerLabel.Text = "Manager:";
            // 
            // locationIDLabel
            // 
            locationIDLabel.AutoSize = true;
            locationIDLabel.BackColor = System.Drawing.Color.Transparent;
            locationIDLabel.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            locationIDLabel.Location = new System.Drawing.Point(12, 118);
            locationIDLabel.Name = "locationIDLabel";
            locationIDLabel.Size = new System.Drawing.Size(83, 17);
            locationIDLabel.TabIndex = 7;
            locationIDLabel.Text = "Location ID:";
            // 
            // booksDBDataSet
            // 
            this.booksDBDataSet.DataSetName = "BooksDBDataSet";
            this.booksDBDataSet.SchemaSerializationMode = System.Data.SchemaSerializationMode.IncludeSchema;
            // 
            // departmentsBindingSource
            // 
            this.departmentsBindingSource.DataMember = "departments";
            this.departmentsBindingSource.DataSource = this.booksDBDataSet;
            // 
            // departmentsTableAdapter
            // 
            this.departmentsTableAdapter.ClearBeforeFill = true;
            // 
            // tableAdapterManager
            // 
            this.tableAdapterManager.BackupDataSetBeforeUpdate = false;
            this.tableAdapterManager.BooksTableAdapter = null;
            this.tableAdapterManager.departmentsTableAdapter = this.departmentsTableAdapter;
            this.tableAdapterManager.LocationsTableAdapter = null;
            this.tableAdapterManager.UpdateOrder = Minibibliotek.BooksDBDataSetTableAdapters.TableAdapterManager.UpdateOrderOption.InsertUpdateDelete;
            // 
            // departmentsBindingNavigator
            // 
            this.departmentsBindingNavigator.AddNewItem = this.bindingNavigatorAddNewItem;
            this.departmentsBindingNavigator.BindingSource = this.departmentsBindingSource;
            this.departmentsBindingNavigator.CountItem = this.bindingNavigatorCountItem;
            this.departmentsBindingNavigator.DeleteItem = this.bindingNavigatorDeleteItem;
            this.departmentsBindingNavigator.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.bindingNavigatorMoveFirstItem,
            this.bindingNavigatorMovePreviousItem,
            this.bindingNavigatorSeparator,
            this.bindingNavigatorPositionItem,
            this.bindingNavigatorCountItem,
            this.bindingNavigatorSeparator1,
            this.bindingNavigatorMoveNextItem,
            this.bindingNavigatorMoveLastItem,
            this.bindingNavigatorSeparator2,
            this.bindingNavigatorAddNewItem,
            this.bindingNavigatorDeleteItem,
            this.departmentsBindingNavigatorSaveItem});
            this.departmentsBindingNavigator.Location = new System.Drawing.Point(0, 0);
            this.departmentsBindingNavigator.MoveFirstItem = this.bindingNavigatorMoveFirstItem;
            this.departmentsBindingNavigator.MoveLastItem = this.bindingNavigatorMoveLastItem;
            this.departmentsBindingNavigator.MoveNextItem = this.bindingNavigatorMoveNextItem;
            this.departmentsBindingNavigator.MovePreviousItem = this.bindingNavigatorMovePreviousItem;
            this.departmentsBindingNavigator.Name = "departmentsBindingNavigator";
            this.departmentsBindingNavigator.PositionItem = this.bindingNavigatorPositionItem;
            this.departmentsBindingNavigator.Size = new System.Drawing.Size(284, 25);
            this.departmentsBindingNavigator.TabIndex = 0;
            this.departmentsBindingNavigator.Text = "bindingNavigator1";
            // 
            // bindingNavigatorAddNewItem
            // 
            this.bindingNavigatorAddNewItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.bindingNavigatorAddNewItem.Image = ((System.Drawing.Image)(resources.GetObject("bindingNavigatorAddNewItem.Image")));
            this.bindingNavigatorAddNewItem.Name = "bindingNavigatorAddNewItem";
            this.bindingNavigatorAddNewItem.RightToLeftAutoMirrorImage = true;
            this.bindingNavigatorAddNewItem.Size = new System.Drawing.Size(23, 22);
            this.bindingNavigatorAddNewItem.Text = "Add new";
            // 
            // bindingNavigatorCountItem
            // 
            this.bindingNavigatorCountItem.Name = "bindingNavigatorCountItem";
            this.bindingNavigatorCountItem.Size = new System.Drawing.Size(35, 22);
            this.bindingNavigatorCountItem.Text = "of {0}";
            this.bindingNavigatorCountItem.ToolTipText = "Total number of items";
            // 
            // bindingNavigatorDeleteItem
            // 
            this.bindingNavigatorDeleteItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.bindingNavigatorDeleteItem.Image = ((System.Drawing.Image)(resources.GetObject("bindingNavigatorDeleteItem.Image")));
            this.bindingNavigatorDeleteItem.Name = "bindingNavigatorDeleteItem";
            this.bindingNavigatorDeleteItem.RightToLeftAutoMirrorImage = true;
            this.bindingNavigatorDeleteItem.Size = new System.Drawing.Size(23, 22);
            this.bindingNavigatorDeleteItem.Text = "Delete";
            // 
            // bindingNavigatorMoveFirstItem
            // 
            this.bindingNavigatorMoveFirstItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.bindingNavigatorMoveFirstItem.Image = ((System.Drawing.Image)(resources.GetObject("bindingNavigatorMoveFirstItem.Image")));
            this.bindingNavigatorMoveFirstItem.Name = "bindingNavigatorMoveFirstItem";
            this.bindingNavigatorMoveFirstItem.RightToLeftAutoMirrorImage = true;
            this.bindingNavigatorMoveFirstItem.Size = new System.Drawing.Size(23, 22);
            this.bindingNavigatorMoveFirstItem.Text = "Move first";
            // 
            // bindingNavigatorMovePreviousItem
            // 
            this.bindingNavigatorMovePreviousItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.bindingNavigatorMovePreviousItem.Image = ((System.Drawing.Image)(resources.GetObject("bindingNavigatorMovePreviousItem.Image")));
            this.bindingNavigatorMovePreviousItem.Name = "bindingNavigatorMovePreviousItem";
            this.bindingNavigatorMovePreviousItem.RightToLeftAutoMirrorImage = true;
            this.bindingNavigatorMovePreviousItem.Size = new System.Drawing.Size(23, 22);
            this.bindingNavigatorMovePreviousItem.Text = "Move previous";
            // 
            // bindingNavigatorSeparator
            // 
            this.bindingNavigatorSeparator.Name = "bindingNavigatorSeparator";
            this.bindingNavigatorSeparator.Size = new System.Drawing.Size(6, 25);
            // 
            // bindingNavigatorPositionItem
            // 
            this.bindingNavigatorPositionItem.AccessibleName = "Position";
            this.bindingNavigatorPositionItem.AutoSize = false;
            this.bindingNavigatorPositionItem.Name = "bindingNavigatorPositionItem";
            this.bindingNavigatorPositionItem.Size = new System.Drawing.Size(50, 23);
            this.bindingNavigatorPositionItem.Text = "0";
            this.bindingNavigatorPositionItem.ToolTipText = "Current position";
            // 
            // bindingNavigatorSeparator1
            // 
            this.bindingNavigatorSeparator1.Name = "bindingNavigatorSeparator1";
            this.bindingNavigatorSeparator1.Size = new System.Drawing.Size(6, 25);
            // 
            // bindingNavigatorMoveNextItem
            // 
            this.bindingNavigatorMoveNextItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.bindingNavigatorMoveNextItem.Image = ((System.Drawing.Image)(resources.GetObject("bindingNavigatorMoveNextItem.Image")));
            this.bindingNavigatorMoveNextItem.Name = "bindingNavigatorMoveNextItem";
            this.bindingNavigatorMoveNextItem.RightToLeftAutoMirrorImage = true;
            this.bindingNavigatorMoveNextItem.Size = new System.Drawing.Size(23, 22);
            this.bindingNavigatorMoveNextItem.Text = "Move next";
            // 
            // bindingNavigatorMoveLastItem
            // 
            this.bindingNavigatorMoveLastItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.bindingNavigatorMoveLastItem.Image = ((System.Drawing.Image)(resources.GetObject("bindingNavigatorMoveLastItem.Image")));
            this.bindingNavigatorMoveLastItem.Name = "bindingNavigatorMoveLastItem";
            this.bindingNavigatorMoveLastItem.RightToLeftAutoMirrorImage = true;
            this.bindingNavigatorMoveLastItem.Size = new System.Drawing.Size(23, 22);
            this.bindingNavigatorMoveLastItem.Text = "Move last";
            // 
            // bindingNavigatorSeparator2
            // 
            this.bindingNavigatorSeparator2.Name = "bindingNavigatorSeparator2";
            this.bindingNavigatorSeparator2.Size = new System.Drawing.Size(6, 25);
            // 
            // departmentsBindingNavigatorSaveItem
            // 
            this.departmentsBindingNavigatorSaveItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.departmentsBindingNavigatorSaveItem.Image = ((System.Drawing.Image)(resources.GetObject("departmentsBindingNavigatorSaveItem.Image")));
            this.departmentsBindingNavigatorSaveItem.Name = "departmentsBindingNavigatorSaveItem";
            this.departmentsBindingNavigatorSaveItem.Size = new System.Drawing.Size(23, 22);
            this.departmentsBindingNavigatorSaveItem.Text = "Save Data";
            this.departmentsBindingNavigatorSaveItem.Click += new System.EventHandler(this.departmentsBindingNavigatorSaveItem_Click);
            // 
            // departmentIDTextBox
            // 
            this.departmentIDTextBox.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.departmentsBindingSource, "DepartmentID", true));
            this.departmentIDTextBox.Location = new System.Drawing.Point(121, 39);
            this.departmentIDTextBox.Name = "departmentIDTextBox";
            this.departmentIDTextBox.ReadOnly = true;
            this.departmentIDTextBox.Size = new System.Drawing.Size(100, 20);
            this.departmentIDTextBox.TabIndex = 2;
            // 
            // nameTextBox
            // 
            this.nameTextBox.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.departmentsBindingSource, "Name", true));
            this.nameTextBox.Location = new System.Drawing.Point(121, 65);
            this.nameTextBox.Name = "nameTextBox";
            this.nameTextBox.Size = new System.Drawing.Size(100, 20);
            this.nameTextBox.TabIndex = 4;
            // 
            // managerTextBox
            // 
            this.managerTextBox.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.departmentsBindingSource, "Manager", true));
            this.managerTextBox.Location = new System.Drawing.Point(121, 91);
            this.managerTextBox.Name = "managerTextBox";
            this.managerTextBox.Size = new System.Drawing.Size(100, 20);
            this.managerTextBox.TabIndex = 6;
            // 
            // locationIDTextBox
            // 
            this.locationIDTextBox.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.departmentsBindingSource, "LocationID", true));
            this.locationIDTextBox.Location = new System.Drawing.Point(121, 117);
            this.locationIDTextBox.Name = "locationIDTextBox";
            this.locationIDTextBox.Size = new System.Drawing.Size(100, 20);
            this.locationIDTextBox.TabIndex = 8;
            // 
            // DepartmentsForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("$this.BackgroundImage")));
            this.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.ClientSize = new System.Drawing.Size(284, 211);
            this.Controls.Add(departmentIDLabel);
            this.Controls.Add(this.departmentIDTextBox);
            this.Controls.Add(nameLabel);
            this.Controls.Add(this.nameTextBox);
            this.Controls.Add(managerLabel);
            this.Controls.Add(this.managerTextBox);
            this.Controls.Add(locationIDLabel);
            this.Controls.Add(this.locationIDTextBox);
            this.Controls.Add(this.departmentsBindingNavigator);
            this.Name = "DepartmentsForm";
            this.Text = "Departments";
            this.Load += new System.EventHandler(this.DepartmentsForm_Load);
            ((System.ComponentModel.ISupportInitialize)(this.booksDBDataSet)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.departmentsBindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.departmentsBindingNavigator)).EndInit();
            this.departmentsBindingNavigator.ResumeLayout(false);
            this.departmentsBindingNavigator.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private BooksDBDataSet booksDBDataSet;
        private System.Windows.Forms.BindingSource departmentsBindingSource;
        private BooksDBDataSetTableAdapters.departmentsTableAdapter departmentsTableAdapter;
        private BooksDBDataSetTableAdapters.TableAdapterManager tableAdapterManager;
        private System.Windows.Forms.BindingNavigator departmentsBindingNavigator;
        private System.Windows.Forms.ToolStripButton bindingNavigatorAddNewItem;
        private System.Windows.Forms.ToolStripLabel bindingNavigatorCountItem;
        private System.Windows.Forms.ToolStripButton bindingNavigatorDeleteItem;
        private System.Windows.Forms.ToolStripButton bindingNavigatorMoveFirstItem;
        private System.Windows.Forms.ToolStripButton bindingNavigatorMovePreviousItem;
        private System.Windows.Forms.ToolStripSeparator bindingNavigatorSeparator;
        private System.Windows.Forms.ToolStripTextBox bindingNavigatorPositionItem;
        private System.Windows.Forms.ToolStripSeparator bindingNavigatorSeparator1;
        private System.Windows.Forms.ToolStripButton bindingNavigatorMoveNextItem;
        private System.Windows.Forms.ToolStripButton bindingNavigatorMoveLastItem;
        private System.Windows.Forms.ToolStripSeparator bindingNavigatorSeparator2;
        private System.Windows.Forms.ToolStripButton departmentsBindingNavigatorSaveItem;
        private System.Windows.Forms.TextBox departmentIDTextBox;
        private System.Windows.Forms.TextBox nameTextBox;
        private System.Windows.Forms.TextBox managerTextBox;
        private System.Windows.Forms.TextBox locationIDTextBox;
    }
}