namespace Minibibliotek
{
    partial class LocationsForm
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
            System.Windows.Forms.Label locationIDLabel;
            System.Windows.Forms.Label floorLabel;
            System.Windows.Forms.Label roomLabel;
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(LocationsForm));
            this.booksDBDataSet = new Minibibliotek.BooksDBDataSet();
            this.locationsBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.locationsTableAdapter = new Minibibliotek.BooksDBDataSetTableAdapters.LocationsTableAdapter();
            this.tableAdapterManager = new Minibibliotek.BooksDBDataSetTableAdapters.TableAdapterManager();
            this.locationsBindingNavigator = new System.Windows.Forms.BindingNavigator(this.components);
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
            this.locationsBindingNavigatorSaveItem = new System.Windows.Forms.ToolStripButton();
            this.locationIDTextBox = new System.Windows.Forms.TextBox();
            this.floorTextBox = new System.Windows.Forms.TextBox();
            this.roomTextBox = new System.Windows.Forms.TextBox();
            locationIDLabel = new System.Windows.Forms.Label();
            floorLabel = new System.Windows.Forms.Label();
            roomLabel = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize)(this.booksDBDataSet)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.locationsBindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.locationsBindingNavigator)).BeginInit();
            this.locationsBindingNavigator.SuspendLayout();
            this.SuspendLayout();
            // 
            // locationIDLabel
            // 
            locationIDLabel.AutoSize = true;
            locationIDLabel.BackColor = System.Drawing.Color.Transparent;
            locationIDLabel.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            locationIDLabel.Location = new System.Drawing.Point(12, 58);
            locationIDLabel.Name = "locationIDLabel";
            locationIDLabel.Size = new System.Drawing.Size(83, 17);
            locationIDLabel.TabIndex = 1;
            locationIDLabel.Text = "Location ID:";
            // 
            // floorLabel
            // 
            floorLabel.AutoSize = true;
            floorLabel.BackColor = System.Drawing.Color.Transparent;
            floorLabel.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            floorLabel.Location = new System.Drawing.Point(12, 84);
            floorLabel.Name = "floorLabel";
            floorLabel.Size = new System.Drawing.Size(44, 17);
            floorLabel.TabIndex = 3;
            floorLabel.Text = "Floor:";
            // 
            // roomLabel
            // 
            roomLabel.AutoSize = true;
            roomLabel.BackColor = System.Drawing.Color.Transparent;
            roomLabel.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            roomLabel.Location = new System.Drawing.Point(12, 110);
            roomLabel.Name = "roomLabel";
            roomLabel.Size = new System.Drawing.Size(49, 17);
            roomLabel.TabIndex = 5;
            roomLabel.Text = "Room:";
            // 
            // booksDBDataSet
            // 
            this.booksDBDataSet.DataSetName = "BooksDBDataSet";
            this.booksDBDataSet.SchemaSerializationMode = System.Data.SchemaSerializationMode.IncludeSchema;
            // 
            // locationsBindingSource
            // 
            this.locationsBindingSource.DataMember = "Locations";
            this.locationsBindingSource.DataSource = this.booksDBDataSet;
            // 
            // locationsTableAdapter
            // 
            this.locationsTableAdapter.ClearBeforeFill = true;
            // 
            // tableAdapterManager
            // 
            this.tableAdapterManager.BackupDataSetBeforeUpdate = false;
            this.tableAdapterManager.BooksTableAdapter = null;
            this.tableAdapterManager.departmentsTableAdapter = null;
            this.tableAdapterManager.LocationsTableAdapter = this.locationsTableAdapter;
            this.tableAdapterManager.UpdateOrder = Minibibliotek.BooksDBDataSetTableAdapters.TableAdapterManager.UpdateOrderOption.InsertUpdateDelete;
            // 
            // locationsBindingNavigator
            // 
            this.locationsBindingNavigator.AddNewItem = this.bindingNavigatorAddNewItem;
            this.locationsBindingNavigator.BindingSource = this.locationsBindingSource;
            this.locationsBindingNavigator.CountItem = this.bindingNavigatorCountItem;
            this.locationsBindingNavigator.DeleteItem = this.bindingNavigatorDeleteItem;
            this.locationsBindingNavigator.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
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
            this.locationsBindingNavigatorSaveItem});
            this.locationsBindingNavigator.Location = new System.Drawing.Point(0, 0);
            this.locationsBindingNavigator.MoveFirstItem = this.bindingNavigatorMoveFirstItem;
            this.locationsBindingNavigator.MoveLastItem = this.bindingNavigatorMoveLastItem;
            this.locationsBindingNavigator.MoveNextItem = this.bindingNavigatorMoveNextItem;
            this.locationsBindingNavigator.MovePreviousItem = this.bindingNavigatorMovePreviousItem;
            this.locationsBindingNavigator.Name = "locationsBindingNavigator";
            this.locationsBindingNavigator.PositionItem = this.bindingNavigatorPositionItem;
            this.locationsBindingNavigator.Size = new System.Drawing.Size(284, 25);
            this.locationsBindingNavigator.TabIndex = 0;
            this.locationsBindingNavigator.Text = "bindingNavigator1";
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
            // locationsBindingNavigatorSaveItem
            // 
            this.locationsBindingNavigatorSaveItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.locationsBindingNavigatorSaveItem.Image = ((System.Drawing.Image)(resources.GetObject("locationsBindingNavigatorSaveItem.Image")));
            this.locationsBindingNavigatorSaveItem.Name = "locationsBindingNavigatorSaveItem";
            this.locationsBindingNavigatorSaveItem.Size = new System.Drawing.Size(23, 22);
            this.locationsBindingNavigatorSaveItem.Text = "Save Data";
            this.locationsBindingNavigatorSaveItem.Click += new System.EventHandler(this.locationsBindingNavigatorSaveItem_Click);
            // 
            // locationIDTextBox
            // 
            this.locationIDTextBox.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.locationsBindingSource, "LocationID", true));
            this.locationIDTextBox.Location = new System.Drawing.Point(101, 55);
            this.locationIDTextBox.Name = "locationIDTextBox";
            this.locationIDTextBox.ReadOnly = true;
            this.locationIDTextBox.Size = new System.Drawing.Size(100, 20);
            this.locationIDTextBox.TabIndex = 2;
            // 
            // floorTextBox
            // 
            this.floorTextBox.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.locationsBindingSource, "Floor", true));
            this.floorTextBox.Location = new System.Drawing.Point(101, 81);
            this.floorTextBox.Name = "floorTextBox";
            this.floorTextBox.Size = new System.Drawing.Size(100, 20);
            this.floorTextBox.TabIndex = 4;
            // 
            // roomTextBox
            // 
            this.roomTextBox.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.locationsBindingSource, "Room", true));
            this.roomTextBox.Location = new System.Drawing.Point(101, 107);
            this.roomTextBox.Name = "roomTextBox";
            this.roomTextBox.Size = new System.Drawing.Size(100, 20);
            this.roomTextBox.TabIndex = 6;
            // 
            // LocationsForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("$this.BackgroundImage")));
            this.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.ClientSize = new System.Drawing.Size(284, 211);
            this.Controls.Add(locationIDLabel);
            this.Controls.Add(this.locationIDTextBox);
            this.Controls.Add(floorLabel);
            this.Controls.Add(this.floorTextBox);
            this.Controls.Add(roomLabel);
            this.Controls.Add(this.roomTextBox);
            this.Controls.Add(this.locationsBindingNavigator);
            this.Name = "LocationsForm";
            this.Text = "Locations";
            this.Load += new System.EventHandler(this.LocationsForm_Load);
            ((System.ComponentModel.ISupportInitialize)(this.booksDBDataSet)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.locationsBindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.locationsBindingNavigator)).EndInit();
            this.locationsBindingNavigator.ResumeLayout(false);
            this.locationsBindingNavigator.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private BooksDBDataSet booksDBDataSet;
        private System.Windows.Forms.BindingSource locationsBindingSource;
        private BooksDBDataSetTableAdapters.LocationsTableAdapter locationsTableAdapter;
        private BooksDBDataSetTableAdapters.TableAdapterManager tableAdapterManager;
        private System.Windows.Forms.BindingNavigator locationsBindingNavigator;
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
        private System.Windows.Forms.ToolStripButton locationsBindingNavigatorSaveItem;
        private System.Windows.Forms.TextBox locationIDTextBox;
        private System.Windows.Forms.TextBox floorTextBox;
        private System.Windows.Forms.TextBox roomTextBox;
    }
}