using System;
using System.Collections.Generic;

#nullable disable

namespace soundOff_api.Models
{
    public partial class Code
    {
        public uint Id { get; set; }
        public Class Class { get; set; }
        public DateTime ClassDate { get; set; }
        public string AttendanceCode { get; set; }
    }
}
