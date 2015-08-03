
>  apm transaction id: 1fb8a828-b662-4ac7-a8cc-0eb9d8578de1
    |- start time: 07/08/2015-12:54:44:277 ms
    |- run time: 293628 ms
    |- node id: core
    |- session id: null
    >  apm transaction detail: class com.iex.tv.services.components.reports.crystal.AdherenceReportComponent:execute
        |- run time: 293628 ms
        >  apm transaction detail: class com.iex.tv.services.impl.core.model.service.user.UserService:getUserByOid
            |- run time: 3 ms
        >  apm transaction detail: class com.iex.tv.services.impl.core.model.service.acl.AccessControlListService:findByOid
            |- run time: 4 ms
        >  apm transaction detail: class com.iex.tv.services.impl.core.model.service.agent.AgentMuAssignmentService:getAgentOids
            |- run time: 56 ms
            >  apm transaction detail: class com.iex.tv.services.impl.core.model.service.resource.ControlledResourceFilterService:attachPermissions
                |- run time: 41 ms
        >  apm transaction detail: class com.iex.tv.services.impl.core.model.service.agent.AgentMuAssignmentService:getAgentMuCalendarDataGroupedByAgent
            |- run time: 236 ms
        >  apm transaction detail: class com.iex.tv.services.impl.core.model.service.activitycode.ActivityCodeService:getAllScheduleActivityCodes
            |- run time: 60 ms 
            >  apm transaction detail: class com.iex.tv.services.impl.core.model.service.resource.ControlledResourceFilterService:attachPermissions
                |- run time: 43 ms
        >  apm transaction detail: class com.iex.tv.services.impl.core.model.service.agent.AgentAcdAssignmentNewService:getAgentAcdsAssignments
            |- run time: 308 ms
        >  apm transaction detail: class com.iex.tv.services.impl.core.model.service.agent.AgentAcdAssignmentNewService:getAgentAcdsAssignments
            |- run time: 401 ms
        >  apm transaction detail: class com.iex.tv.services.impl.core.model.service.agent.AgentAcdAssignmentNewService:getAgentAcdsAssignments
            |- run time: 395 ms
        >  apm transaction detail: class com.iex.tv.services.impl.core.model.service.agent.AgentAcdAssignmentNewService:getAgentAcdsAssignments
            |- run time: 292 ms 
        >  apm transaction detail: class com.iex.tv.services.impl.core.model.service.adhexclusion.AdhExclusionsService:getAdhExclusionsForReports
            |- run time: 12 ms
        >  apm transaction detail: class com.iex.tv.services.impl.core.model.service.activitycode.ActivityCodeAttrService:getDataValues
            |- run time: 5 ms
        >  apm transaction detail: class com.iex.tv.services.impl.core.model.service.activitycode.ActivityCodeAttrValueAssignmentService:getAssignedActivityCodes
            |- run time: 3 ms
        >  apm transaction detail: class com.iex.tv.services.impl.core.model.service.activitycode.ActivityCodeAttrService:getDataValues
            |- run time: 2 ms
        >  apm transaction detail: class com.iex.tv.services.impl.core.model.service.activitycode.ActivityCodeAttrValueAssignmentService:getAssignedActivityCodes
            |- run time: 2 ms
