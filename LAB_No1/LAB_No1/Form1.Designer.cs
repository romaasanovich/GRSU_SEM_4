namespace LAB_No1
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
            this.showProcBtn = new System.Windows.Forms.Button();
            this.dataGridView1 = new System.Windows.Forms.DataGridView();
            this.IdColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.ProcessClmn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.UserClmn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.RAMClmn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.PriorityClmn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.ThreadsClmn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridView2 = new System.Windows.Forms.DataGridView();
            this.ID = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Priority = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.button1 = new System.Windows.Forms.Button();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView2)).BeginInit();
            this.SuspendLayout();
            // 
            // showProcBtn
            // 
            this.showProcBtn.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F);
            this.showProcBtn.Location = new System.Drawing.Point(12, 314);
            this.showProcBtn.Name = "showProcBtn";
            this.showProcBtn.Size = new System.Drawing.Size(122, 55);
            this.showProcBtn.TabIndex = 1;
            this.showProcBtn.Text = " ShowСurrProcesses";
            this.showProcBtn.UseVisualStyleBackColor = true;
            this.showProcBtn.Click += new System.EventHandler(this.button1_Click);
            // 
            // dataGridView1
            // 
            this.dataGridView1.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGridView1.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.IdColumn,
            this.ProcessClmn,
            this.UserClmn,
            this.RAMClmn,
            this.PriorityClmn,
            this.ThreadsClmn});
            this.dataGridView1.Location = new System.Drawing.Point(12, 12);
            this.dataGridView1.Name = "dataGridView1";
            this.dataGridView1.Size = new System.Drawing.Size(455, 296);
            this.dataGridView1.TabIndex = 2;
            // 
            // IdColumn
            // 
            this.IdColumn.HeaderText = "Id";
            this.IdColumn.Name = "IdColumn";
            this.IdColumn.Width = 45;
            // 
            // ProcessClmn
            // 
            this.ProcessClmn.HeaderText = "Process";
            this.ProcessClmn.Name = "ProcessClmn";
            // 
            // UserClmn
            // 
            this.UserClmn.HeaderText = "User";
            this.UserClmn.Name = "UserClmn";
            // 
            // RAMClmn
            // 
            this.RAMClmn.HeaderText = "RAM";
            this.RAMClmn.Name = "RAMClmn";
            this.RAMClmn.Width = 55;
            // 
            // PriorityClmn
            // 
            this.PriorityClmn.HeaderText = "Priority";
            this.PriorityClmn.Name = "PriorityClmn";
            this.PriorityClmn.Width = 55;
            // 
            // ThreadsClmn
            // 
            this.ThreadsClmn.HeaderText = "Threads";
            this.ThreadsClmn.Name = "ThreadsClmn";
            this.ThreadsClmn.Width = 55;
            // 
            // dataGridView2
            // 
            this.dataGridView2.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGridView2.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.ID,
            this.Priority});
            this.dataGridView2.Location = new System.Drawing.Point(484, 12);
            this.dataGridView2.Name = "dataGridView2";
            this.dataGridView2.Size = new System.Drawing.Size(182, 296);
            this.dataGridView2.TabIndex = 8;
            // 
            // ID
            // 
            this.ID.HeaderText = "IdClmn";
            this.ID.Name = "ID";
            this.ID.Width = 50;
            // 
            // Priority
            // 
            this.Priority.HeaderText = "priorityClmn";
            this.Priority.Name = "Priority";
            this.Priority.Width = 90;
            // 
            // button1
            // 
            this.button1.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F);
            this.button1.Location = new System.Drawing.Point(151, 314);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(122, 55);
            this.button1.TabIndex = 9;
            this.button1.Text = "Show Threads ";
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.button1_Click_2);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(678, 394);
            this.Controls.Add(this.button1);
            this.Controls.Add(this.dataGridView2);
            this.Controls.Add(this.dataGridView1);
            this.Controls.Add(this.showProcBtn);
            this.Name = "Form1";
            this.Text = "Form1";
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView2)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion
        private System.Windows.Forms.Button showProcBtn;
        private System.Windows.Forms.DataGridView dataGridView1;
        private System.Windows.Forms.DataGridViewTextBoxColumn IdColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn ProcessClmn;
        private System.Windows.Forms.DataGridViewTextBoxColumn UserClmn;
        private System.Windows.Forms.DataGridViewTextBoxColumn RAMClmn;
        private System.Windows.Forms.DataGridViewTextBoxColumn PriorityClmn;
        private System.Windows.Forms.DataGridViewTextBoxColumn ThreadsClmn;
        private System.Windows.Forms.DataGridView dataGridView2;
        private System.Windows.Forms.DataGridViewTextBoxColumn ID;
        private System.Windows.Forms.DataGridViewTextBoxColumn Priority;
        private System.Windows.Forms.Button button1;
    }
}

