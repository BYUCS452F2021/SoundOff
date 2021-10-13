using System;
using System.Collections.Generic;

#nullable disable

namespace soundOff_api.Models
{
    public partial class Enrollment
    {
        public uint Id { get; set; }
        public Class Class { get; set; }
        public Student Student { get; set; }
    }
}
