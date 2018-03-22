using System;
using System.Diagnostics;
using System.Linq;
using System.Management;

namespace LAB_No1
{
    class ProcessWorker
    {
        private Process[] processes;

        public Process[] Processes { get => processes; set => processes = value; }


        public ProcessWorker()
        {
            Processes = Process.GetProcesses();
        }

        public static Process[] showAllProcesses()
        {
            return Process.GetProcesses();
        }

        public static string GetProcessOwner(int processId)
        {
            var query = "Select * From Win32_Process Where ProcessID = " + processId;
            ManagementObjectCollection processList;

            using (var searcher = new ManagementObjectSearcher(query))
            {
                processList = searcher.Get();
            }

            foreach (var mo in processList.OfType<ManagementObject>())
            {
                object[] argList = { string.Empty, string.Empty };
                var returnVal = Convert.ToInt32(mo.InvokeMethod("GetOwner", argList));

                if (returnVal == 0)
                {
                    return argList[0].ToString();
                }
            }

            return "System";
        }
    }

}
