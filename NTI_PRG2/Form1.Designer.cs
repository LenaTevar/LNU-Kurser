namespace Loggboken_v2
{
    partial class Form1
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
            this.menuStrip1 = new System.Windows.Forms.MenuStrip();
            this.addBookToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.addBookToolStripMenuItem1 = new System.Windows.Forms.ToolStripMenuItem();
            this.findBookToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.exportLogToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.exportAndCloseToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.windowToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.cascadeToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.tileHorizontalToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.tileVerticalToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.menuStrip1.SuspendLayout();
            this.SuspendLayout();
            // 
            // menuStrip1
            // 
            this.menuStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.addBookToolStripMenuItem,
            this.windowToolStripMenuItem});
            this.menuStrip1.Location = new System.Drawing.Point(0, 0);
            this.menuStrip1.Name = "menuStrip1";
            this.menuStrip1.Size = new System.Drawing.Size(1064, 24);
            this.menuStrip1.TabIndex = 0;
            this.menuStrip1.Text = "menuStrip1";
            // 
            // addBookToolStripMenuItem
            // 
            this.addBookToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.addBookToolStripMenuItem1,
            this.findBookToolStripMenuItem,
            this.exportLogToolStripMenuItem,
            this.exportAndCloseToolStripMenuItem});
            this.addBookToolStripMenuItem.Name = "addBookToolStripMenuItem";
            this.addBookToolStripMenuItem.Size = new System.Drawing.Size(37, 20);
            this.addBookToolStripMenuItem.Text = "File";
            // 
            // addBookToolStripMenuItem1
            // 
            this.addBookToolStripMenuItem1.Name = "addBookToolStripMenuItem1";
            this.addBookToolStripMenuItem1.Size = new System.Drawing.Size(162, 22);
            this.addBookToolStripMenuItem1.Text = "Add Book";
            this.addBookToolStripMenuItem1.Click += new System.EventHandler(this.addBookToolStripMenuItem1_Click);
            // 
            // findBookToolStripMenuItem
            // 
            this.findBookToolStripMenuItem.Name = "findBookToolStripMenuItem";
            this.findBookToolStripMenuItem.Size = new System.Drawing.Size(162, 22);
            this.findBookToolStripMenuItem.Text = "Find Book";
            this.findBookToolStripMenuItem.Click += new System.EventHandler(this.findBookToolStripMenuItem_Click);
            // 
            // exportLogToolStripMenuItem
            // 
            this.exportLogToolStripMenuItem.Name = "exportLogToolStripMenuItem";
            this.exportLogToolStripMenuItem.Size = new System.Drawing.Size(162, 22);
            this.exportLogToolStripMenuItem.Text = "Show Log";
            // 
            // exportAndCloseToolStripMenuItem
            // 
            this.exportAndCloseToolStripMenuItem.Name = "exportAndCloseToolStripMenuItem";
            this.exportAndCloseToolStripMenuItem.Size = new System.Drawing.Size(162, 22);
            this.exportAndCloseToolStripMenuItem.Text = "Export and Close";
            this.exportAndCloseToolStripMenuItem.Click += new System.EventHandler(this.exportAndCloseToolStripMenuItem_Click);
            // 
            // windowToolStripMenuItem
            // 
            this.windowToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.cascadeToolStripMenuItem,
            this.tileHorizontalToolStripMenuItem,
            this.tileVerticalToolStripMenuItem});
            this.windowToolStripMenuItem.Name = "windowToolStripMenuItem";
            this.windowToolStripMenuItem.Size = new System.Drawing.Size(63, 20);
            this.windowToolStripMenuItem.Text = "Window";
            // 
            // cascadeToolStripMenuItem
            // 
            this.cascadeToolStripMenuItem.Name = "cascadeToolStripMenuItem";
            this.cascadeToolStripMenuItem.Size = new System.Drawing.Size(151, 22);
            this.cascadeToolStripMenuItem.Text = "Cascade";
            this.cascadeToolStripMenuItem.Click += new System.EventHandler(this.cascadeToolStripMenuItem_Click);
            // 
            // tileHorizontalToolStripMenuItem
            // 
            this.tileHorizontalToolStripMenuItem.Name = "tileHorizontalToolStripMenuItem";
            this.tileHorizontalToolStripMenuItem.Size = new System.Drawing.Size(151, 22);
            this.tileHorizontalToolStripMenuItem.Text = "Tile Horizontal";
            this.tileHorizontalToolStripMenuItem.Click += new System.EventHandler(this.tileHorizontalToolStripMenuItem_Click);
            // 
            // tileVerticalToolStripMenuItem
            // 
            this.tileVerticalToolStripMenuItem.Name = "tileVerticalToolStripMenuItem";
            this.tileVerticalToolStripMenuItem.Size = new System.Drawing.Size(151, 22);
            this.tileVerticalToolStripMenuItem.Text = "Tile Vertical";
            this.tileVerticalToolStripMenuItem.Click += new System.EventHandler(this.tileVerticalToolStripMenuItem_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1064, 681);
            this.Controls.Add(this.menuStrip1);
            this.IsMdiContainer = true;
            this.MainMenuStrip = this.menuStrip1;
            this.Name = "Form1";
            this.Text = "Loggboken v2";
            this.menuStrip1.ResumeLayout(false);
            this.menuStrip1.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.MenuStrip menuStrip1;
        private System.Windows.Forms.ToolStripMenuItem addBookToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem addBookToolStripMenuItem1;
        private System.Windows.Forms.ToolStripMenuItem findBookToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem exportLogToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem exportAndCloseToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem windowToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem cascadeToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem tileHorizontalToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem tileVerticalToolStripMenuItem;
    }
}

