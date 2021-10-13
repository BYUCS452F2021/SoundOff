using System;
using System.Collections.Generic;

#nullable disable

namespace soundOff_api.Models
{
    public partial class Student
    {
        public uint Id { get; set; }
        public string Name { get; set; }
        public string Major { get; set; }
        public string Phone { get; set; }
        public string Email { get; set; }
        public string Password { get; set; }
        public List<Attendance> Attendances { get; set; }
        public List <Enrollment> Enrollments { get; set; }
    }
}
