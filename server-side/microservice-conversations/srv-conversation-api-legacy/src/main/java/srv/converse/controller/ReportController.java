package srv.converse.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import srv.converse.dto.ReportDTO;
import srv.converse.model.Report;
import srv.converse.service.ReportService;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author vladimir.fedotov
 * @since 16-Mar-20
 */
@Controller
@RequestMapping(value = "/report")
public class ReportController {

    private ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @RequestMapping(value = "/{reportId}", method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    public ReportDTO getReportById(@PathVariable Long reportId) {
        Report report = reportService.retreiveReport(reportId);
        return ReportDTO.fromReport(report);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public void updateReport(@RequestBody Report report) {
        reportService.updateReport(report);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void createReport(@RequestBody Report report) {
        reportService.createReport(report);
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<ReportDTO> findAllReport() {
        Collection<Report> reports = reportService.retreiveAllReport();
        Collection<ReportDTO> reportDTOs = new ArrayList<>();
        for (Report report : reports) {
            reportDTOs.add(ReportDTO.fromReport(report));
        }
        return reportDTOs;
    }
}
