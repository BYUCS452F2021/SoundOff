using System;
using System.Collections.Generic;

#nullable disable

namespace soundOff_api.Models
{
    public partial class Attendance
    {
        public uint Id { get; set; }
        public DateTime AttendanceTimestamp { get; set; }
        public string Location { get; set; }

        public Class Class { get; set; }
        public Student Student { get; set; }
    }
}
