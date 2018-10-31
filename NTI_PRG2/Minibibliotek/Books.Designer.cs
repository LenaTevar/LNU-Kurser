namespace Minibibliotek
{
    partial class BooksForm
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
            System.Windows.Forms.Label bookIDLabel;
            System.Windows.Forms.Label titleLabel;
            System.Windows.Forms.Label authorLabel;
            System.Windows.Forms.Label departmentIDLabel;
            System.Windows.Forms.Label locationIDLabel;
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(BooksForm));
            this.booksBindingNavigator = new System.Windows.Forms.BindingNavigator(this.components);
            this.bindingNavigatorAddNewItem = new System.Windows.Forms.ToolStripButton();
            this.booksBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.booksDBDataSet = new Minibibliotek.BooksDBDataSet();
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
            this.booksBindingNavigatorSaveItem = new System.Windows.Forms.ToolStripButton();
            this.bookIDTextBox = new System.Windows.Forms.TextBox();
            this.titleTextBox = new System.Windows.Forms.TextBox();
            this.authorTextBox = new System.Windows.Forms.TextBox();
            this.departmentIDTextBox = new System.Windows.Forms.TextBox();
            this.locationIDTextBox = new System.Windows.Forms.TextBox();
            this.booksTableAdapter = new Minibibliotek.BooksDBDataSetTableAdapters.BooksTableAdapter();
            this.tableAdapterManager = new Minibibliotek.BooksDBDataSetTableAdapters.TableAdapterManager();
            bookIDLabel = new System.Windows.Forms.Label();
            titleLabel = new System.Windows.Forms.Label();
            authorLabel = new System.Windows.Forms.Label();
            departmentIDLabel = new System.Windows.Forms.Label();
            locationIDLabel = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize)(this.booksBindingNavigator)).BeginInit();
            this.booksBindingNavigator.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.booksBindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.booksDBDataSet)).BeginInit();
            this.SuspendLayout();
            // 
            // bookIDLabel
            // 
            bookIDLabel.AutoSize = true;
            bookIDLabel.BackColor = System.Drawing.Color.Transparent;
            bookIDLabel.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            bookIDLabel.Location = new System.Drawing.Point(12, 40);
            bookIDLabel.Name = "bookIDLabel";
            bookIDLabel.Size = new System.Drawing.Size(61, 17);
            bookIDLabel.TabIndex = 1;
            bookIDLabel.Text = "Book ID:";
            // 
            // titleLabel
            // 
            titleLabel.AutoSize = true;
            titleLabel.BackColor = System.Drawing.Color.Transparent;
            titleLabel.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            titleLabel.Location = new System.Drawing.Point(12, 66);
            titleLabel.Name = "titleLabel";
            titleLabel.Size = new System.Drawing.Size(39, 17);
            titleLabel.TabIndex = 3;
            titleLabel.Text = "Title:";
            // 
            // authorLabel
            // 
            authorLabel.AutoSize = true;
            authorLabel.BackColor = System.Drawing.Color.Transparent;
            authorLabel.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            authorLabel.Location = new System.Drawing.Point(12, 92);
            authorLabel.Name = "authorLabel";
            authorLabel.Size = new System.Drawing.Size(54, 17);
            authorLabel.TabIndex = 5;
            authorLabel.Text = "Author:";
            // 
            // departmentIDLabel
            // 
            departmentIDLabel.AutoSize = true;
            departmentIDLabel.BackColor = System.Drawing.Color.Transparent;
            departmentIDLabel.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            departmentIDLabel.Location = new System.Drawing.Point(12, 118);
            departmentIDLabel.Name = "departmentIDLabel";
            departmentIDLabel.Size = new System.Drawing.Size(103, 17);
            departmentIDLabel.TabIndex = 7;
            departmentIDLabel.Text = "Department ID:";
            // 
            // locationIDLabel
            // 
            locationIDLabel.AutoSize = true;
            locationIDLabel.BackColor = System.Drawing.Color.Transparent;
            locationIDLabel.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            locationIDLabel.Location = new System.Drawing.Point(12, 144);
            locationIDLabel.Name = "locationIDLabel";
            locationIDLabel.Size = new System.Drawing.Size(83, 17);
            locationIDLabel.TabIndex = 9;
            locationIDLabel.Text = "Location ID:";
            // 
            // booksBindingNavigator
            // 
            this.booksBindingNavigator.AddNewItem = this.bindingNavigatorAddNewItem;
            this.booksBindingNavigator.BindingSource = this.booksBindingSource;
            this.booksBindingNavigator.CountItem = this.bindingNavigatorCountItem;
            this.booksBindingNavigator.DeleteItem = this.bindingNavigatorDeleteItem;
            this.booksBindingNavigator.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
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
            this.booksBindingNavigatorSaveItem});
            this.booksBindingNavigator.Location = new System.Drawing.Point(0, 0);
            this.booksBindingNavigator.MoveFirstItem = this.bindingNavigatorMoveFirstItem;
            this.booksBindingNavigator.MoveLastItem = this.bindingNavigatorMoveLastItem;
            this.booksBindingNavigator.MoveNextItem = this.bindingNavigatorMoveNextItem;
            this.booksBindingNavigator.MovePreviousItem = this.bindingNavigatorMovePreviousItem;
            this.booksBindingNavigator.Name = "booksBindingNavigator";
            this.booksBindingNavigator.PositionItem = this.bindingNavigatorPositionItem;
            this.booksBindingNavigator.Size = new System.Drawing.Size(284, 25);
            this.booksBindingNavigator.TabIndex = 0;
            this.booksBindingNavigator.Text = "bindingNavigator1";
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
            // booksBindingSource
            // 
            this.booksBindingSource.DataMember = "Books";
            this.booksBindingSource.DataSource = this.booksDBDataSet;
            // 
            // booksDBDataSet
            // 
            this.booksDBDataSet.DataSetName = "BooksDBDataSet";
            this.booksDBDataSet.SchemaSerializationMode = System.Data.SchemaSerializationMode.IncludeSchema;
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
            // booksBindingNavigatorSaveItem
            // 
            this.booksBindingNavigatorSaveItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.booksBindingNavigatorSaveItem.Image = ((System.Drawing.Image)(resources.GetObject("booksBindingNavigatorSaveItem.Image")));
            this.booksBindingNavigatorSaveItem.Name = "booksBindingNavigatorSaveItem";
            this.booksBindingNavigatorSaveItem.Size = new System.Drawing.Size(23, 22);
            this.booksBindingNavigatorSaveItem.Text = "Save Data";
            this.booksBindingNavigatorSaveItem.Click += new System.EventHandler(this.booksBindingNavigatorSaveItem_Click);
            // 
            // bookIDTextBox
            // 
            this.bookIDTextBox.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.booksBindingSource, "BookID", true));
            this.bookIDTextBox.Location = new System.Drawing.Point(133, 40);
            this.bookIDTextBox.Name = "bookIDTextBox";
            this.bookIDTextBox.ReadOnly = true;
            this.bookIDTextBox.Size = new System.Drawing.Size(100, 20);
            this.bookIDTextBox.TabIndex = 2;
            // 
            // titleTextBox
            // 
            this.titleTextBox.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.booksBindingSource, "Title", true));
            this.titleTextBox.Location = new System.Drawing.Point(133, 66);
            this.titleTextBox.Name = "titleTextBox";
            this.titleTextBox.Size = new System.Drawing.Size(100, 20);
            this.titleTextBox.TabIndex = 4;
            // 
            // authorTextBox
            // 
            this.authorTextBox.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.booksBindingSource, "Author", true));
            this.authorTextBox.Location = new System.Drawing.Point(133, 92);
            this.authorTextBox.Name = "authorTextBox";
            this.authorTextBox.Size = new System.Drawing.Size(100, 20);
            this.authorTextBox.TabIndex = 6;
            // 
            // departmentIDTextBox
            // 
            this.departmentIDTextBox.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.booksBindingSource, "DepartmentID", true));
            this.departmentIDTextBox.Location = new System.Drawing.Point(133, 118);
            this.departmentIDTextBox.Name = "departmentIDTextBox";
            this.departmentIDTextBox.Size = new System.Drawing.Size(100, 20);
            this.departmentIDTextBox.TabIndex = 8;
            // 
            // locationIDTextBox
            // 
            this.locationIDTextBox.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.booksBindingSource, "LocationID", true));
            this.locationIDTextBox.Location = new System.Drawing.Point(133, 144);
            this.locationIDTextBox.Name = "locationIDTextBox";
            this.locationIDTextBox.Size = new System.Drawing.Size(100, 20);
            this.locationIDTextBox.TabIndex = 10;
            // 
            // booksTableAdapter
            // 
            this.booksTableAdapter.ClearBeforeFill = true;
            // 
            // tableAdapterManager
            // 
            this.tableAdapterManager.BackupDataSetBeforeUpdate = false;
            this.tableAdapterManager.BooksTableAdapter = this.booksTableAdapter;
            this.tableAdapterManager.departmentsTableAdapter = null;
            this.tableAdapterManager.LocationsTableAdapter = null;
            this.tableAdapterManager.UpdateOrder = Minibibliotek.BooksDBDataSetTableAdapters.TableAdapterManager.UpdateOrderOption.InsertUpdateDelete;
            // 
            // BooksForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("$this.BackgroundImage")));
            this.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.ClientSize = new System.Drawing.Size(284, 211);
            this.Controls.Add(bookIDLabel);
            this.Controls.Add(this.bookIDTextBox);
            this.Controls.Add(titleLabel);
            this.Controls.Add(this.titleTextBox);
            this.Controls.Add(authorLabel);
            this.Controls.Add(this.authorTextBox);
            this.Controls.Add(departmentIDLabel);
            this.Controls.Add(this.departmentIDTextBox);
            this.Controls.Add(locationIDLabel);
            this.Controls.Add(this.locationIDTextBox);
            this.Controls.Add(this.booksBindingNavigator);
            this.Name = "BooksForm";
            this.Text = "Books";
            this.Load += new System.EventHandler(this.BooksForm_Load);
            ((System.ComponentModel.ISupportInitialize)(this.booksBindingNavigator)).EndInit();
            this.booksBindingNavigator.ResumeLayout(false);
            this.booksBindingNavigator.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.booksBindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.booksDBDataSet)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private BooksDBDataSet booksDBDataSet;
        private System.Windows.Forms.BindingSource booksBindingSource;
        private BooksDBDataSetTableAdapters.BooksTableAdapter booksTableAdapter;
        private BooksDBDataSetTableAdapters.TableAdapterManager tableAdapterManager;
        private System.Windows.Forms.BindingNavigator booksBindingNavigator;
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
        private System.Windows.Forms.ToolStripButton booksBindingNavigatorSaveItem;
        private System.Windows.Forms.TextBox bookIDTextBox;
        private System.Windows.Forms.TextBox titleTextBox;
        private System.Windows.Forms.TextBox authorTextBox;
        private System.Windows.Forms.TextBox departmentIDTextBox;
        private System.Windows.Forms.TextBox locationIDTextBox;
    }
}