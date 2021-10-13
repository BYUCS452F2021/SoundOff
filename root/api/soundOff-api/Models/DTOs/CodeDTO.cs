using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace soundOff_api.Models.DTOs
{
    public class CodeDTO
    {
        public uint Id { get; set; }
        public ClassDTO Class { get; set; }
        public DateTime ClassDate { get; set; }
        public string AttendanceCode { get; set; }

        public CodeDTO () { }
        public CodeDTO (Code c)
        {
            Id = c.Id;
            ClassDate = c.ClassDate;
            AttendanceCode = c.AttendanceCode;

            if (c.Class != null)
                Class = new ClassDTO(c.Class);

        }
    }
}
