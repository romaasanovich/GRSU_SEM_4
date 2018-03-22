using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Diagnostics;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace LAB_No1
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            dataGridView1.Rows.Clear();
            foreach (Process proc in new ProcessWorker().Processes)
            {
                String name = ProcessWorker.GetProcessOwner(proc.Id);
                long ram = (proc.PrivateMemorySize64 >> 20);
                dataGridView1.Rows.Add(proc.Id, proc.ProcessName, name,ram.ToString(), proc.BasePriority, proc.Threads.Count);
            }
        }

        private void button1_Click_2(object sender, EventArgs e)
        {
            dataGridView2.Rows.Clear();
            int row = dataGridView1.CurrentCell.RowIndex;
            int procIndex = (Int32)dataGridView1.CurrentRow.Cells[0].Value;
            Process proc = Process.GetProcessById(procIndex);
            foreach (ProcessThread thr in proc.Threads)
            {
                dataGridView2.Rows.Add(thr.Id, thr.BasePriority);
            }
        }

   
    }
}
