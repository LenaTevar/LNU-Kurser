namespace Loggboken_v2
{
    partial class nyBokForm
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
            this.txtbIsbn = new System.Windows.Forms.TextBox();
            this.labelF_ISBN = new System.Windows.Forms.Label();
            this.labelF_NewBook = new System.Windows.Forms.Label();
            this.toErase_01 = new System.Windows.Forms.Label();
            this.btn_NewBok01 = new System.Windows.Forms.Button();
            this.btn_NewBokAdd = new System.Windows.Forms.Button();
            this.btn_NewBokClose = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // txtbIsbn
            // 
            this.txtbIsbn.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txtbIsbn.Location = new System.Drawing.Point(74, 51);
            this.txtbIsbn.Name = "txtbIsbn";
            this.txtbIsbn.Size = new System.Drawing.Size(170, 23);
            this.txtbIsbn.TabIndex = 0;
            // 
            // labelF_ISBN
            // 
            this.labelF_ISBN.AutoSize = true;
            this.labelF_ISBN.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.labelF_ISBN.Location = new System.Drawing.Point(12, 54);
            this.labelF_ISBN.Name = "labelF_ISBN";
            this.labelF_ISBN.Size = new System.Drawing.Size(39, 17);
            this.labelF_ISBN.TabIndex = 1;
            this.labelF_ISBN.Text = "ISBN";
            // 
            // labelF_NewBook
            // 
            this.labelF_NewBook.AutoSize = true;
            this.labelF_NewBook.Font = new System.Drawing.Font("Microsoft Sans Serif", 15F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.labelF_NewBook.Location = new System.Drawing.Point(10, 9);
            this.labelF_NewBook.Name = "labelF_NewBook";
            this.labelF_NewBook.Size = new System.Drawing.Size(153, 25);
            this.labelF_NewBook.TabIndex = 2;
            this.labelF_NewBook.Text = "Add a new book";
            // 
            // toErase_01
            // 
            this.toErase_01.AutoSize = true;
            this.toErase_01.Location = new System.Drawing.Point(411, 60);
            this.toErase_01.Name = "toErase_01";
            this.toErase_01.Size = new System.Drawing.Size(0, 13);
            this.toErase_01.TabIndex = 3;
            // 
            // btn_NewBok01
            // 
            this.btn_NewBok01.Location = new System.Drawing.Point(274, 51);
            this.btn_NewBok01.Name = "btn_NewBok01";
            this.btn_NewBok01.Size = new System.Drawing.Size(75, 23);
            this.btn_NewBok01.TabIndex = 4;
            this.btn_NewBok01.Text = "Check";
            this.btn_NewBok01.UseVisualStyleBackColor = true;
            this.btn_NewBok01.Click += new System.EventHandler(this.btn_NewBok01_Click);
            // 
            // btn_NewBokAdd
            // 
            this.btn_NewBokAdd.Location = new System.Drawing.Point(414, 226);
            this.btn_NewBokAdd.Name = "btn_NewBokAdd";
            this.btn_NewBokAdd.Size = new System.Drawing.Size(75, 23);
            this.btn_NewBokAdd.TabIndex = 5;
            this.btn_NewBokAdd.Text = "Add";
            this.btn_NewBokAdd.UseVisualStyleBackColor = true;
            this.btn_NewBokAdd.Click += new System.EventHandler(this.btn_NewBokAdd_Click);
            // 
            // btn_NewBokClose
            // 
            this.btn_NewBokClose.Location = new System.Drawing.Point(495, 226);
            this.btn_NewBokClose.Name = "btn_NewBokClose";
            this.btn_NewBokClose.Size = new System.Drawing.Size(75, 23);
            this.btn_NewBokClose.TabIndex = 6;
            this.btn_NewBokClose.Text = "Close";
            this.btn_NewBokClose.UseVisualStyleBackColor = true;
            this.btn_NewBokClose.Click += new System.EventHandler(this.btn_NewBokClose_Click);
            // 
            // nyBokForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(584, 261);
            this.Controls.Add(this.btn_NewBokClose);
            this.Controls.Add(this.btn_NewBokAdd);
            this.Controls.Add(this.btn_NewBok01);
            this.Controls.Add(this.toErase_01);
            this.Controls.Add(this.labelF_NewBook);
            this.Controls.Add(this.labelF_ISBN);
            this.Controls.Add(this.txtbIsbn);
            this.Name = "nyBokForm";
            this.Text = "Logg Bok - Ny Bok";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TextBox txtbIsbn;
        private System.Windows.Forms.Label labelF_ISBN;
        private System.Windows.Forms.Label labelF_NewBook;
        private System.Windows.Forms.Label toErase_01;
        private System.Windows.Forms.Button btn_NewBok01;
        private System.Windows.Forms.Button btn_NewBokAdd;
        private System.Windows.Forms.Button btn_NewBokClose;
    }
}