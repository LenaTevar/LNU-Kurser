namespace Loggboken_v2
{
    partial class FindBok
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
            this.lblFB_FindBook = new System.Windows.Forms.Label();
            this.listBoxFB = new System.Windows.Forms.ListBox();
            this.txtFB = new System.Windows.Forms.TextBox();
            this.btnFB = new System.Windows.Forms.Button();
            this.lblFBanswer = new System.Windows.Forms.Label();
            this.btnFBClose = new System.Windows.Forms.Button();
            this.btnFBModify = new System.Windows.Forms.Button();
            this.btnFBErase = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // lblFB_FindBook
            // 
            this.lblFB_FindBook.AutoSize = true;
            this.lblFB_FindBook.Font = new System.Drawing.Font("Microsoft Sans Serif", 15F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblFB_FindBook.Location = new System.Drawing.Point(13, 13);
            this.lblFB_FindBook.Name = "lblFB_FindBook";
            this.lblFB_FindBook.Size = new System.Drawing.Size(116, 25);
            this.lblFB_FindBook.TabIndex = 0;
            this.lblFB_FindBook.Text = "Find a Book";
            // 
            // listBoxFB
            // 
            this.listBoxFB.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.listBoxFB.FormattingEnabled = true;
            this.listBoxFB.ItemHeight = 16;
            this.listBoxFB.Items.AddRange(new object[] {
            "ISBN",
            "Title",
            "Author"});
            this.listBoxFB.Location = new System.Drawing.Point(18, 59);
            this.listBoxFB.Name = "listBoxFB";
            this.listBoxFB.Size = new System.Drawing.Size(57, 52);
            this.listBoxFB.TabIndex = 1;
            // 
            // txtFB
            // 
            this.txtFB.Location = new System.Drawing.Point(91, 59);
            this.txtFB.Multiline = true;
            this.txtFB.Name = "txtFB";
            this.txtFB.Size = new System.Drawing.Size(267, 52);
            this.txtFB.TabIndex = 2;
            // 
            // btnFB
            // 
            this.btnFB.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F);
            this.btnFB.Location = new System.Drawing.Point(384, 59);
            this.btnFB.Name = "btnFB";
            this.btnFB.Size = new System.Drawing.Size(83, 52);
            this.btnFB.TabIndex = 3;
            this.btnFB.Text = "Check";
            this.btnFB.UseVisualStyleBackColor = true;
            // 
            // lblFBanswer
            // 
            this.lblFBanswer.AutoSize = true;
            this.lblFBanswer.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F);
            this.lblFBanswer.Location = new System.Drawing.Point(18, 136);
            this.lblFBanswer.Name = "lblFBanswer";
            this.lblFBanswer.Size = new System.Drawing.Size(89, 17);
            this.lblFBanswer.TabIndex = 4;
            this.lblFBanswer.Text = "blehblehbleh";
            // 
            // btnFBClose
            // 
            this.btnFBClose.Location = new System.Drawing.Point(497, 226);
            this.btnFBClose.Name = "btnFBClose";
            this.btnFBClose.Size = new System.Drawing.Size(75, 23);
            this.btnFBClose.TabIndex = 5;
            this.btnFBClose.Text = "Close";
            this.btnFBClose.UseVisualStyleBackColor = true;
            this.btnFBClose.Click += new System.EventHandler(this.btnFBClose_Click);
            // 
            // btnFBModify
            // 
            this.btnFBModify.Location = new System.Drawing.Point(21, 226);
            this.btnFBModify.Name = "btnFBModify";
            this.btnFBModify.Size = new System.Drawing.Size(75, 23);
            this.btnFBModify.TabIndex = 6;
            this.btnFBModify.Text = "Modify";
            this.btnFBModify.UseVisualStyleBackColor = true;
            // 
            // btnFBErase
            // 
            this.btnFBErase.Location = new System.Drawing.Point(103, 226);
            this.btnFBErase.Name = "btnFBErase";
            this.btnFBErase.Size = new System.Drawing.Size(75, 23);
            this.btnFBErase.TabIndex = 7;
            this.btnFBErase.Text = "Erase";
            this.btnFBErase.UseVisualStyleBackColor = true;
            // 
            // FindBok
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(584, 261);
            this.Controls.Add(this.btnFBErase);
            this.Controls.Add(this.btnFBModify);
            this.Controls.Add(this.btnFBClose);
            this.Controls.Add(this.lblFBanswer);
            this.Controls.Add(this.btnFB);
            this.Controls.Add(this.txtFB);
            this.Controls.Add(this.listBoxFB);
            this.Controls.Add(this.lblFB_FindBook);
            this.Name = "FindBok";
            this.Text = "FindBok";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label lblFB_FindBook;
        private System.Windows.Forms.ListBox listBoxFB;
        private System.Windows.Forms.TextBox txtFB;
        private System.Windows.Forms.Button btnFB;
        private System.Windows.Forms.Label lblFBanswer;
        private System.Windows.Forms.Button btnFBClose;
        private System.Windows.Forms.Button btnFBModify;
        private System.Windows.Forms.Button btnFBErase;
    }
}