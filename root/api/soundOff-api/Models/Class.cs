using System;
using System.Collections.Generic;

#nullable disable

namespace soundOff_api.Models
{
    public partial class Class
    {
        public uint Id { get; set; }
        public string SectionNumber { get; set; }
        public string ClassName { get; set; }
        public Professor Professor { get; set; }
        public List<Attendance> Attendances { get; set; }
        public List<Enrollment> Enrollments { get; set; }
    }
}
