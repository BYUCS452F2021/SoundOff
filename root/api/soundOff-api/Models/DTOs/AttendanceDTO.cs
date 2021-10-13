using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace soundOff_api.Models.DTOs
{
    public class AttendanceDTO
    {

        public uint Id { get; set; }
        public DateTime AttendanceTimestamp { get; set; }
        public string Location { get; set; }

        public ClassDTO Class { get; set; }
        public StudentDTO Student { get; set; }

        public AttendanceDTO() { }
        public AttendanceDTO(Attendance a)
        {
            Id = a.Id;
            AttendanceTimestamp = a.AttendanceTimestamp;
            Location = a.Location;

            if (a.Class != null)
                Class = new ClassDTO(a.Class);

            if (a.Student != null)
                Student = new StudentDTO(a.Student);

        }
    }
}
